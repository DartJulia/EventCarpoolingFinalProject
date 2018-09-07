package com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class Event {

	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("start_time")
	private String start_time;
	
	@JsonProperty("venue_name")
	private String venue_name;
	
	//add latitude/longitude

	public Event() {
	}

	public Event(String id, String title, String start_time, String venue_name) {
		super();
		this.id = id;
		this.title = title;
		this.start_time = start_time;
		this.venue_name = venue_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getVenue_name() {
		return venue_name;
	}

	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", start_time=" + start_time + ", venue_name=" + venue_name
				+ "]";
	}
}
