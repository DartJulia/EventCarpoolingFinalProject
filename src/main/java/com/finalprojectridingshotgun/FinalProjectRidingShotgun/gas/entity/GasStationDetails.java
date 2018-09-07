package com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class GasStationDetails {
	
	@JsonProperty("reg_price")
	private String gasPrice;

	public GasStationDetails() {
		// TODO Auto-generated constructor stub
	}

	public String getGasPrice() {
		return gasPrice;
	}

	public void setGasPrice(String gasPrice) {
		this.gasPrice = gasPrice;
	}

	@Override
	public String toString() {
		return "GasStationDetails gasPrice=" + gasPrice;
	}

	
	
}
