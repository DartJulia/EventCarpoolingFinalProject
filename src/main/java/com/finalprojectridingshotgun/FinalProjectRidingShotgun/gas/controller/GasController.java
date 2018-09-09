package com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity.GasStations;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity.StationOptions;

@Controller
public class GasController {
	
	@Value("${gas.key}")
	String gasID;


	
	//This method finds the last gas station that has the most expensive gas in the array that is pulled from a 1 mile radius from a location.
	@RequestMapping("gasprice")
	public ModelAndView regGasPrice(@RequestParam("lat") Double lat, @RequestParam("lng") Double lng) {
		RestTemplate restTemplate = new RestTemplate();
		GasStations station = restTemplate.getForObject("http://api.mygasfeed.com/stations/radius/" + lat + "/" + lng + "/1.0/reg/price/" + gasID + ".json", GasStations.class);
		ArrayList<StationOptions> priceForCost = station.getChosenStation();
		priceForCost.get(priceForCost.size() - 1).getGasPrice();
		
	//	return new ModelAndView("index", "price", station.getStationDetails().getGasPrice());
		return new ModelAndView("index", "price", priceForCost.get(priceForCost.size() - 1).getGasPrice());
	}
	
}
