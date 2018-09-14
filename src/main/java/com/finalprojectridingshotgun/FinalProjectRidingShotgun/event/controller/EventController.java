package com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.finalprojectridingshotgun.FinalProjectRidingShotgun.Calculator;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity.Entry;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity.Event;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity.Events;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.Ride;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.RideRepository;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.User;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.UserRepository;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.UserRide;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.UserRideRepository;


@Controller
@SessionAttributes({"echosen", "sessionUser"})
public class EventController {
	
	@Autowired
	RideRepository riderepo;
	
	@Autowired
	UserRideRepository urRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Value("${maps.key}")
	String map;

	@Value("${events.key}")
	String eId; // event key

	@RequestMapping("/")
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/driversearch")
	public ModelAndView driverSearch() {

		ModelAndView mv = new ModelAndView("driversearch");
		return mv;
	}

	@RequestMapping("/allsearch")
	public ModelAndView searchAll(@RequestParam("queryloc") String queryloc,
			@RequestParam("queryname") String queryname, @RequestParam("querydate") String querydate) {

		RestTemplate restTemplate = eventRest();

		HttpEntity<String> entity = eventHeaders();

		ResponseEntity<Entry> response = restTemplate
				.exchange(
						"https://api.eventful.com/json/events/search?app_key=" + eId + "&location=" + queryloc
								+ "&q=" + queryname + "&page_size=30&image_sizes=medium",
				HttpMethod.GET,
				entity,
				Entry.class);

		// get Entry
		Entry entry = response.getBody();

		// get Events
		Events events = entry.getEvents();

		// get ArrayList<Event>
		ArrayList<Event> result = events.getEventList();

		ModelAndView av = new ModelAndView("driver_results");

		queryloc = queryloc.toUpperCase();
		queryname = queryname.toUpperCase();
		querydate = querydate.toUpperCase();

		av.addObject("queryloc", queryloc);
		av.addObject("queryname", queryname);
		av.addObject("querydate", querydate);
		av.addObject("events", result);

		return av;
	}
	@RequestMapping("/rideresult")
	public ModelAndView searchForRides(@RequestParam("queryloc") String location, 
			@RequestParam("queryname") String title, @RequestParam("querydate") String start_time) {
		ModelAndView rsv = new ModelAndView("rideresults", "titletag", riderepo.findByEventtitleContaining(title));
		rsv.addObject("ridenumber", "placeholder");
		return rsv;
	}
	// TODO: method to parse date and time

	// TODO: pull rides from database here
	@RequestMapping("/event/{id}/{title}/{start}/{venue}/{lat}/{lon}")
	public ModelAndView viewEvent(@PathVariable("id") String id, @PathVariable("title") String title,
			@PathVariable("start") String start, @PathVariable("venue") String v, @PathVariable("lat") String lat,
			@PathVariable("lon") String lon, HttpSession session) {
		ModelAndView ev = new ModelAndView("view-event");
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		Event e = new Event(id, title, start, v, lat, lon);
		System.out.println(e);
		User user = (User)session.getAttribute("sessionUser");
		Calculator calc = new Calculator();
		ev.addObject("cost", numberFormat.format(calc.pricePerRider(user, e, map)));
		ev.addObject("costfor2", numberFormat.format((calc.pricePerRider(user, e,map)) / 2));
		ev.addObject("costfor3", numberFormat.format((calc.pricePerRider(user, e, map)) / 3));

		session.setAttribute("echosen", e);
//		List<Ride> rides = riderepo.findByEventid(id);
//		ev.addObject("ridelist", rides);
		ev.addObject("latit", lat);
		ev.addObject("longit", lon);
	
		return ev;
	}
	
	@RequestMapping("/joinride/{ride_id}/{user_id}")
	public ModelAndView ridejoin(@PathVariable("ride_id") Long rideId, @PathVariable("user_id") Long userId) {
		ModelAndView rjv = new ModelAndView("join-ride");
		UserRide ur = new UserRide(userId, rideId);
		urRepo.save(ur);
		User d = userRepo.getOne(riderepo.getOne(rideId).getUserid());
		String event = riderepo.getOne(rideId).getEventtitle();
		rjv.addObject("user", userRepo.getOne(userId).getFirst_name());
		rjv.addObject("ride", d.getFirst_name());
		rjv.addObject("event", event);
		return rjv;
		
	}
		@RequestMapping("/registerdriver/{id}/{title}/{user_id}")
	public ModelAndView driveRegister(@PathVariable("id") String eventid, @PathVariable("title") String eventtitle, 
			@PathVariable("user_id") Long user_id) {
		// User u = (User) session.getAttribute("sessionUser");
		Ride r = new Ride(eventid, eventtitle, user_id);
		riderepo.save(r);
		return new ModelAndView("redirect:/");
	}
	



	// helper method
	public HttpEntity<String> eventHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		return entity;
	}

	// helper method
	public RestTemplate eventRest() {
		// for getting around SSL certification, pass into the RestTemplate
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);

		RestTemplate restTemplate = new RestTemplate(requestFactory);

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.ALL);
		MappingJackson2HttpMessageConverter jaxbMessageConverter = new MappingJackson2HttpMessageConverter();

		jaxbMessageConverter.setSupportedMediaTypes(mediaTypes);
		messageConverters.add(jaxbMessageConverter);
		restTemplate.setMessageConverters(messageConverters);
		return restTemplate;
	}

}
