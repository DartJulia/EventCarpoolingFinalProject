package com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Medium {

	@JsonProperty("url")
	private String url;

	public Medium() {

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Medium [url=" + url + "]";
	}

}
