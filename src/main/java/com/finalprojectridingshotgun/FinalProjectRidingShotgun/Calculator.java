package com.finalprojectridingshotgun.FinalProjectRidingShotgun;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity.Event;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity.GasStations;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity.StationOptions;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity.JsonWrapper;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity.Routes;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.RideRepository;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.User;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.UserRepository;

@SessionAttributes({ "echosen", "sessionUser" })

public class Calculator {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RideRepository rideRepo;
	
	public double pricePerRider(@ModelAttribute("sessionUser") User userOrigin,
			@ModelAttribute("echosen") Event e, String map) {
		

		// User userOrigin = (User) session.getAttribute("sessionUser");
		System.out.println(userOrigin);
		//Event e = (Event) session.getAttribute("echosen");
		System.out.println(e);
		System.out.println(e.getLatitude() + e.getLongitude());
		System.out.println(userOrigin.getAddress());
		Calculator calc = new Calculator();
		
		double gasPrice = calc.gasPriceAtLoc(e);
		double tripDist = calc.findTripDistance(userOrigin, e, map);
		System.out.println("Made it here now!!!");
		Double tripCost = (((tripDist / 24)) * gasPrice);
		System.out.println(calc.findTripDistance(userOrigin, e, map));
		return tripCost;
	}

	public Double findTripDistance(@ModelAttribute("sessionUser") User userOrigin, @ModelAttribute("echosen") Event e,
			String map) {

		RestTemplate restTemp = new RestTemplate();
		JsonWrapper tripDistance = restTemp.getForObject(
				"https://maps.googleapis.com/maps/api/directions/json?origin=" + userOrigin.getAddress()
						+ "&destination=" + e.getLatitude() + "," + e.getLongitude() + "&key=" + map,
				JsonWrapper.class);
		// add map back in or not?

		// Added this to match the maps controller, it was missing from here.
		ArrayList<Routes> distance = tripDistance.getRoutes();

		System.out.println(distance);

		String dist = distance.get(0).getLegs().get(0).getDistance().getText();
		String[] miles = dist.split(" ");

		Double milesParse = Double.parseDouble(miles[0]);
		return milesParse;
	}

	public Double gasPriceAtLoc(Event e) {

		RestTemplate restTemplate = new RestTemplate(); // add milesParse?

		GasStations station = restTemplate.getForObject("http://api.mygasfeed.com/stations/radius/" + e.getLatitude()
				+ "/" + e.getLongitude() + "/1.0/reg/price/1zu5wjxobp.json", GasStations.class);
		ArrayList<StationOptions> priceForCost = station.getChosenStation();
		String pfc = priceForCost.get(priceForCost.size() - 1).getGasPrice();
//		Double tripCost = (((findTripDistance("sessionUser", "echosen") / 24)) * Double.parseDouble(pfc));
		System.out.println(pfc);
		return Double.parseDouble(pfc);

	}



}
