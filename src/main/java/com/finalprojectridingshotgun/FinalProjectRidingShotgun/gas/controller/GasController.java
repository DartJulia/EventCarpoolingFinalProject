package com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "echosen", "sessionUser", "milesParse" })
public class GasController {
	
	@Value("${gas.key}")
	String gasID;


	// @RequestParam("lat") Double lat, @RequestParam("lng") Double lng,
	//This method finds the last gas station that has the most expensive gas in the array that is pulled from a 1 mile radius from a location.
//	@RequestMapping("/gasprice")
//	public ModelAndView regGasPrice(HttpSession session) {
//		Event e = (Event) session.getAttribute("echosen");
//
//		String pfc = gasPriceAtLoc(e);
		
	//	return new ModelAndView("index", "price", station.getStationDetails().getGasPrice());
		//return new ModelAndView("view-event", "price", priceForCost.get(priceForCost.size() - 1).getGasPrice());
//		return new ModelAndView("view-event", "price", pfc);
//	}


//	public Double gasPriceAtLoc(Event e, HttpSession session) {
//		ShotgunController sC = new ShotgunController();
//		session.getAttribute("sessionUser");
//		session.getAttribute("echosen");
//		sC.milesParsed(session);
//		RestTemplate restTemplate = new RestTemplate(); // add milesParse?
//
//		GasStations station = restTemplate.getForObject("http://api.mygasfeed.com/stations/radius/" + e.getLatitude()
//				+ "/" + e.getLongitude() + "/1.0/reg/price/" + gasID + ".json", GasStations.class);
//		ArrayList<StationOptions> priceForCost = station.getChosenStation();
//		String pfc = priceForCost.get(priceForCost.size() - 1).getGasPrice();
//		Double tripCost = (((sC.milesParse(session) / 24)) * Double.parseDouble(pfc));
//		System.out.println(tripCost);
//		return tripCost;
		// tripCost = (milesParse/mpg) * pfc;
	}
	
//	@RequestMapping("/cost of trip")
//	public ModelAndView costOfGasForTrip() {
//		GasController totalPrice = new GasController();
//		totalPrice.gasPriceAtLoc("echosen", "sessionUser");
//		return totalPrice.gasPriceAtLoc("echosen", "sessionUser");
//	}
//	
//}
