package com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Legs {

	private Distance distance;
	private Duration duration;
	@JsonProperty("end_location")
	private EndLocation endLocation;
	@JsonProperty("start_location")
	private StartLocation startLocation;

	public Legs() {

	}

	public Distance getDistance() {
		return distance;
	}

	public void setDistance(Distance distance) {
		this.distance = distance;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public EndLocation getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(EndLocation endLocation) {
		this.endLocation = endLocation;
	}

	public StartLocation getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(StartLocation startLocation) {
		this.startLocation = startLocation;
	}

	@Override
	public String toString() {
		return "Legs [distance=" + distance + ", duration=" + duration + ", endLocation=" + endLocation
				+ ", startLocation=" + startLocation + "]";
	}

}
