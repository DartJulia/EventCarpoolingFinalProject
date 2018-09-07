package com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Entry {
	
	@JsonProperty("total_items")
	private int total_items;
	
	@JsonProperty("events")
	private Events events;

	public Entry() {
	}

	public int getTotal_items() {
		return total_items;
	}

	public void setTotal_items(int total_items) {
		this.total_items = total_items;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Entry"  + total_items + ", events=" + events + "]";
	}
	
}
