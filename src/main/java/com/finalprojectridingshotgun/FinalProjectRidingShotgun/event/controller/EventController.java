package com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ModelAttribute;
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
@SessionAttributes({ "echosen", "sessionUser", "riderevent" })
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

		ModelAndView dsv = new ModelAndView("driversearch");
		return dsv;
	}
	
	
	@RequestMapping("/ridesearch")
	public ModelAndView rideSearch() {
		ModelAndView rsv = new ModelAndView("ridesearch");
		return rsv;
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
	
	
	// display rider search results from ride database
	@RequestMapping("/rideresults")
	public ModelAndView searchForRides(@RequestParam("querycity") String city, 
			@RequestParam("querystate") String state, @RequestParam("querytitle") String title) {
		//ModelAndView rsv = new ModelAndView("rideresults", "titletag", riderepo.findByEventtitleContaining(title));
		ModelAndView rsv = new ModelAndView("rideresults");

		Ride driver = riderepo.findUserIdByCityOrRegion(city, state);
		Long driverId = driver.getUserid();
		Optional<User> user = userRepo.findById(driverId);
		System.out.println(driverId);
		rsv.addObject("titletag", riderepo.findByCityOrRegion(city, state));
//		rsv.addObject("titletag", riderepo.findByEventtitleContainingOrCityOrRegion(title, city, state));
		rsv.addObject("gender", user.get().getGender());
		rsv.addObject("drivername", user.get().getFirst_name());
//		TODO: find a way to use both queries
		//rsv.addObject("titletag", riderepo.findByEventtitleContaining(title));
		return rsv;
	}
	
	
	
	// TODO: method to parse date and time

	// TODO: pull rides from database here
	@RequestMapping("/event/{id}/{title}/{start}/{venue}/{lat}/{lon}/{city}/{region}")
	public ModelAndView viewEvent(@PathVariable("id") String id, @PathVariable("title") String title,
			@PathVariable("start") String start, @PathVariable("venue") String v, @PathVariable("lat") String lat,
			@PathVariable("lon") String lon, HttpSession session, @PathVariable("city") String city, @PathVariable("region") String state) {
		ModelAndView ev = new ModelAndView("view-event");
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		Event e = new Event(id, title, start, v, lat, lon, city, state);
		System.out.println(e);
		User user = (User) session.getAttribute("sessionUser");
		Calculator calc = new Calculator();
		ev.addObject("cost", numberFormat.format(calc.pricePerRider(user, map, lat, lon)));
		ev.addObject("costfor2", numberFormat.format((calc.pricePerRider(user, map, lat, lon)) / 2));
		ev.addObject("costfor3", numberFormat.format((calc.pricePerRider(user, map, lat, lon)) / 3));

		session.setAttribute("echosen", e);
//		List<Ride> rides = riderepo.findByEventid(id);
//		ev.addObject("ridelist", rides);
		ev.addObject("title", e.getTitle());
//		ev.addObject("latit", lat);
//		ev.addObject("longit", lon);
	
		return ev;
	}
	

	
// Pulls ride details from database including price, rider name and event title - one more step to add to userride database	
	@RequestMapping("/joinride/{ride_id}/{user_id}")
	public ModelAndView rideDetails(@PathVariable("ride_id") Long rideId, @PathVariable("user_id") Long userId,
			HttpSession session) {
		ModelAndView rjv = new ModelAndView("join-ride");
		User user = (User)session.getAttribute("sessionUser");
		
		session.setAttribute("riderevent", rideId);

		Calculator calc = new Calculator();
		DecimalFormat numberFormat = new DecimalFormat("#.00");

		Ride driver = riderepo.getOne(rideId);
		Long driverid = driver.getUserid();
		Optional<User> driveruser = userRepo.findById(driverid);
//		int maxSeats = driveruser.get().getSeats();
//		driver.setAvailseats(maxSeats);
		int seats = driver.getAvailseats();
		rjv.addObject("seats", seats);
		
		if (driver.getAvailseats() < 1) {
			return new ModelAndView("/ridefull");
		}
		
		rjv.addObject("drivername", driveruser.get().getFirst_name());
		rjv.addObject("ridername", user.getFirst_name());
		rjv.addObject("title", riderepo.findEventtitleByRideid(rideId).getEventtitle());

		Ride rideLat = riderepo.findLatitudeByRideid(rideId);
		String latitude = rideLat.getLatitude();
		Ride rideLong = riderepo.findLatitudeByRideid(rideId);
		String longitude = rideLong.getLongitude();
		String costString = numberFormat.format(calc.pricePerRider(user, map, latitude, longitude));
		double cost = Double.parseDouble(costString);
		
		rjv.addObject("cost", numberFormat.format(cost));
		rjv.addObject("costfor2", numberFormat.format(cost / 2));
		rjv.addObject("costfor3", numberFormat.format(cost / 3));

		return rjv;
		
	}

//Saves rider with driver in user_ride database	
	@RequestMapping("/saveride/{riderevent}/{user_id}")
	public ModelAndView ridejoin(@ModelAttribute("riderevent") Long rideId, @PathVariable("user_id") Long userId,
			@RequestParam("trip") String trip, HttpSession session) {
		System.out.println("Made it");
		ModelAndView rjv = new ModelAndView("summary");
		System.out.println("Rideid:" + rideId);
		Ride ride = riderepo.getOne(rideId);
		
		
		
		ride.setAvailseats(ride.getAvailseats()-1);
		
		riderepo.save(ride);
		
		UserRide ur = new UserRide(userId, rideId);
		urRepo.save(ur);
		

		User user = (User) session.getAttribute("sessionUser");
		
		Calculator calc = new Calculator();
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		Ride rideLat = riderepo.findLatitudeByRideid(rideId);
		String latitude = rideLat.getLatitude();
		Ride rideLong = riderepo.findLatitudeByRideid(rideId);
		String longitude = rideLong.getLongitude();
		String costString = numberFormat.format(calc.pricePerRider(user, map, latitude, longitude));
		double cost = Double.parseDouble(costString);
		// true = round trip
		if (trip.equals("round")) {
			rjv.addObject("cost", numberFormat.format(cost * 2));
			rjv.addObject("costfor2", numberFormat.format((cost * 2) / 2));
			rjv.addObject("costfor3", numberFormat.format((cost * 2) / 3));
		}
		// false = one way
		else {
			rjv.addObject("cost", numberFormat.format(cost));
			rjv.addObject("costfor2", numberFormat.format(cost / 2));
			rjv.addObject("costfor3", numberFormat.format(cost / 3));
		}

		return rjv;

	}

// Method adds a new ride to ride_database on the "driver side"
	@RequestMapping("/registerdriver/{id}/{title}/{user_id}/{city_name}/{region_name}/{lat}/{lon}")
	public ModelAndView rideRegister(@PathVariable("id") String eventid, @PathVariable("title") String eventtitle, 
			@PathVariable("user_id") Long user_id, @PathVariable("city_name") String city,
			@PathVariable("region_name") String state, @PathVariable("lat") String lat,
			@PathVariable("lon") String lon) {
//		 User u = (User) session.getAttribute("sessionUser");
		Optional<User> user = userRepo.findById(user_id);
		Integer seats = user.get().getSeats();
		System.out.println("Seats: " + seats);
		Ride r = new Ride(eventid, eventtitle, user_id, city, state, lat, lon, seats);
		riderepo.save(r);
		return new ModelAndView("redirect:/");
	}

	
	@RequestMapping("/ridefull")
	public ModelAndView fullride() {
		return new ModelAndView("ridefull");
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
