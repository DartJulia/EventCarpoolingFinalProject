package com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EndLocation {

	private double lat;
	private double lng;

	public EndLocation() {

	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "EndLocation [lat=" + lat + ", lng=" + lng + "]";
	}

}
