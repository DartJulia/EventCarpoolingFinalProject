package com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity;

import java.util.ArrayList;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class Events {
	
	@JsonProperty("event")
	private ArrayList<Event> eventList;

	public Events() {
	}

	public ArrayList<Event> getEventList() {
		return eventList;
	}

	public void setEventList(ArrayList<Event> eventList) {
		this.eventList = eventList;
	}

	@Override
	public String toString() {
		return "Events [eventList=" + eventList + "]";
	}
}
