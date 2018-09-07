package com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GasStations {
	
	
	@JsonProperty("details")
	private GasStationDetails stationDetails;
	
	@JsonProperty("stations")
	private ArrayList<StationOptions> chosenStation;

	public GasStations() {
		// TODO Auto-generated constructor stub
	}


	

	public ArrayList<StationOptions> getChosenStation() {
		return chosenStation;
	}



	public void setChosenStation(ArrayList<StationOptions> chosenStation) {
		this.chosenStation = chosenStation;
	}




	public GasStationDetails getStationDetails() {
		return stationDetails;
	}

	public void setStationDetails(GasStationDetails stationDetails) {
		this.stationDetails = stationDetails;
	}





	@Override
	public String toString() {
		return "GasStations stationDetails=" + stationDetails;
	}
	
	
	
	

}
