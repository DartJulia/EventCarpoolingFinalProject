package com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StationOptions {
	
	@JsonProperty("reg_price")
	private String gasPrice;

	public String getGasPrice() {
		return gasPrice;
	}

	public void setGasPrice(String gasPrice) {
		this.gasPrice = gasPrice;
	}
	
	

}
