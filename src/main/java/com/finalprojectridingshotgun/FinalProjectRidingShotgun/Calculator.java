package com.finalprojectridingshotgun.FinalProjectRidingShotgun;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity.GasStations;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity.StationOptions;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity.JsonWrapper;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity.Routes;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.RideRepository;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.User;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.UserRepository;

@SessionAttributes("sessionUser")
// Helper class
public class Calculator {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RideRepository rideRepo;
	
// Calculates price of ride using gas price and distance
	public double pricePerRider(@ModelAttribute("sessionUser") User userOrigin, String map, String latitude,
			String longitude) {

		Calculator calc = new Calculator();
		double gasPrice = calc.gasPriceAtLoc(latitude, longitude);
		double tripDist = calc.findTripDistance(userOrigin, map, latitude, longitude);

		Double tripCost = (((tripDist / 24)) * gasPrice);
		return tripCost;
	}

// Gets total trip distance from Google Maps Direction API, using latitude and longitude
	public Double findTripDistance(@ModelAttribute("sessionUser") User userOrigin, String map, String latitude,
			String longitude) {

		RestTemplate restTemp = new RestTemplate();
		JsonWrapper tripDistance = restTemp.getForObject(
				"https://maps.googleapis.com/maps/api/directions/json?origin=" + userOrigin.getAddress()
						+ "&destination=" + latitude + "," + longitude + "&key=" + map,
				JsonWrapper.class);

		ArrayList<Routes> distance = tripDistance.getRoutes();
		String dist = distance.get(0).getLegs().get(0).getDistance().getText();
		System.out.println(dist);
		String[] miles = dist.split(" ");
	//New code added here
		String[] noCommaMiles = miles[0].split(",");
		System.out.println(noCommaMiles[0] + noCommaMiles[1]);
		String newMileFormat = noCommaMiles[0] + noCommaMiles[1];
		System.out.println("Made it here");
		
	//end of new code	
		Double milesParse = Double.parseDouble(newMileFormat);
		return milesParse;
	}

	// Gets a gas price from GasFeed API, using destination latitude and longitude
	public Double gasPriceAtLoc(String latitude, String longitude) {

		RestTemplate restTemplate = new RestTemplate();

		GasStations station = restTemplate.getForObject("http://api.mygasfeed.com/stations/radius/" + latitude + "/"
				+ longitude + "/1.0/reg/price/1zu5wjxobp.json", GasStations.class);
		ArrayList<StationOptions> priceForCost = station.getChosenStation();
		String pfc = priceForCost.get(priceForCost.size() - 1).getGasPrice();

		return Double.parseDouble(pfc);

	}



}
