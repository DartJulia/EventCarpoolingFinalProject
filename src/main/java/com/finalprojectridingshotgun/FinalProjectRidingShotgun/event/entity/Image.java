package com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Image {

	@JsonProperty("thumb")
	private Thumb thumb;

	@JsonProperty("small")
	private Small small;

	@JsonProperty("medium")
	private Medium medium;

	@JsonProperty("url")
	private String url;

		public Image() {
		}

	public Image(Thumb thumb, Small small, Medium medium, String url) {
		this.thumb = thumb;
		this.small = small;
		this.medium = medium;
		this.url = url;
		}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Thumb getThumb() {
		return thumb;
	}

	public void setThumb(Thumb thumb) {
		this.thumb = thumb;
	}

	public Small getSmall() {
		return small;
	}

	public void setSmall(Small small) {
		this.small = small;
	}

	public Medium getMedium() {
		return medium;
	}

	public void setMedium(Medium medium) {
		this.medium = medium;
	}

	@Override
	public String toString() {
		return "Image [thumb=" + thumb + ", small=" + small + ", medium=" + medium + "]";
	}

		
		
}
