package com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

	@JsonIgnoreProperties(ignoreUnknown=true)
	public class Thumb {
		
		@JsonProperty("url")
		private String url;
		
		public Thumb() {
		}
		
		public Thumb(String url) {
			this.url = url;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@Override
		public String toString() {
			return "url";
		}
		
}
