package com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity.Event;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity.GasStations;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity.StationOptions;

@Controller
@SessionAttributes({"echosen","sessionUser"})
public class GasController {
	
	@Value("${gas.key}")
	String gasID;


	// @RequestParam("lat") Double lat, @RequestParam("lng") Double lng,
	//This method finds the last gas station that has the most expensive gas in the array that is pulled from a 1 mile radius from a location.
	@RequestMapping("/gasprice")
	public ModelAndView regGasPrice(HttpSession session) {
		Event e = (Event) session.getAttribute("echosen");

		String pfc = gasPriceAtLoc(e);
		
	//	return new ModelAndView("index", "price", station.getStationDetails().getGasPrice());
		//return new ModelAndView("view-event", "price", priceForCost.get(priceForCost.size() - 1).getGasPrice());
		return new ModelAndView("view-event", "price", pfc);
	}


	public String gasPriceAtLoc(Event e) {   // add milesParse?
		RestTemplate restTemplate = new RestTemplate();
		GasStations station = restTemplate.getForObject("http://api.mygasfeed.com/stations/radius/" + e.getLatitude()
				+ "/" + e.getLongitude() + "/1.0/reg/price/" + gasID + ".json", GasStations.class);
		ArrayList<StationOptions> priceForCost = station.getChosenStation();
		String pfc = priceForCost.get(priceForCost.size() - 1).getGasPrice();
		return pfc;
		// tripCost = (milesParse/mpg) * pfc;
	}
	
}
