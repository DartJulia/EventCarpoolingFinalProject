package com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity;

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
	
	@JsonProperty("latitude")
	private String latitude;

	@JsonProperty("longitude")
	private String longitude;
	
	@JsonProperty("image")
	private Image image;

	@JsonProperty("city_name")
	private String city;
	
	@JsonProperty("region_name")
	private String region;
	
	@JsonProperty("url")
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCity_name() {
		return city;
	}

	public void setCity_name(String city) {
		this.city = city;
	}

	public String getRegion_name() {
		return region;
	}

	public void setRegion_name(String region) {
		this.region = region;
	}

	public Event() {
	}

	public Event(String id, String latitude, String longitude) {
		this.id = id;
	}

	public Event(String id, String title, String start_time, String venue_name, String latitude, String longitude, String city, String region) {
		super();
		this.id = id;
		this.title = title;
		this.start_time = start_time;
		this.venue_name = venue_name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.region = region;
		
	}


	public Event(String id, String title) {
		this.id = id;
		this.title = title;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", start_time=" + start_time + ", venue_name=" + venue_name
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
