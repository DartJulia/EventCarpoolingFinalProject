package com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class StartLocation {

	private float lat;
	private float lng;

	public StartLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "StartLocation [lat=" + lat + ", lng=" + lng + "]";
	}

}
