package com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Image {

		@JsonProperty("thumb")
		private Thumb thumb;

		public Image() {
		}

		public Image(Thumb thumb) {
			this.thumb = thumb;
		}

		public Thumb getThumb() {
			return thumb;
		}

		public void setThumb(Thumb thumb) {
			this.thumb = thumb;
		}

		@Override
		public String toString() {
			return "Image [thumb=" + thumb + "]";
		}
		
		
}
