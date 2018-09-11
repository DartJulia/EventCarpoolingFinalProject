package com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
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

import com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity.Entry;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity.Event;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity.Events;

@Controller
@SessionAttributes("echosen")
public class EventController {

	@Value("${events.key}")
	String eId; // event key

	@RequestMapping("/")
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping("/allsearch")
	public ModelAndView searchAll(@RequestParam("queryloc") String queryloc,
			@RequestParam("queryname") String queryname, @RequestParam("querydate") String querydate) {

		RestTemplate restTemplate = eventRest();

		HttpEntity<String> entity = eventHeaders();

		ResponseEntity<Entry> response = restTemplate.exchange("https://api.eventful.com/json/events/search?app_key="
				+ eId + "&location=" + queryloc + "&q=" + queryname + "&page_size=100&image_sizes=thumb", HttpMethod.GET, entity,
				Entry.class);

		// get Entry
		Entry entry = response.getBody();

		// get Events
		Events events = entry.getEvents();

		// get ArrayList<Event>
		ArrayList<Event> result = events.getEventList();

		ModelAndView av = new ModelAndView("driver-event-results");

		queryloc = queryloc.toUpperCase();
		queryname = queryname.toUpperCase();
		querydate = querydate.toUpperCase();

		av.addObject("queryloc", queryloc);
		av.addObject("queryname", queryname);
		av.addObject("querydate", querydate);
		av.addObject("events", result);

		return av;
	}

	// TODO: method to parse date and time

	// TODO: pull rides from database here
	@RequestMapping("/event/{id}/{title}/{start}/{venue}/{lat}/{lon}")
	public ModelAndView viewEvent(@PathVariable("id") String id, @PathVariable("title") String title,
			@PathVariable("start") String start, @PathVariable("venue") String v, @PathVariable("lat") String lat,
			@PathVariable("lon") String lon, HttpSession session) {
		ModelAndView ev = new ModelAndView("view-event");
		Event e = new Event(id, title, start, v, lat, lon);
		System.out.println(e);
		session.setAttribute("echosen", e);

		ev.addObject("latit", lat);
		ev.addObject("longit", lon);
	
		return ev;
	}

//	@RequestMapping("/event")
//	public ModelAndView viewEvent(@RequestParam("event") Event e) {
//		ModelAndView ev = new ModelAndView("view-event");
//
//
//		System.out.println(e);
////		
////		System.out.println("lat: " + e.getLatitude());
////
////		System.out.println(e.getLongitude());
//		ev.addObject("tag", e);
//		return ev;
//	}

//	@RequestMapping("/event/{id}")
//	public static float[] getLatLong(@PathVariable("id") String id) {
//		Event e = new Event();
//		float lat = e.getLatitude();
//		System.out.println(lat);
//
//		float lon = e.getLongitude();
//		System.out.println(lon);
//		float[] latLong = new float[2];
//		latLong[0] = lat;
//		latLong[1] = lon;
//		return latLong;
//
//	}

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
