package com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Routes {

	private ArrayList<Legs> legs;

	public Routes() {

	}

	public ArrayList<Legs> getLegs() {
		return legs;
	}

	public void setLegs(ArrayList<Legs> legs) {
		this.legs = legs;
	}


	@Override
	public String toString() {
		return "Routes [legs=" + legs + "]";
	}

}
