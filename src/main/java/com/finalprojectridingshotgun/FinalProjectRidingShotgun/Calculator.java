package com.finalprojectridingshotgun.FinalProjectRidingShotgun;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.finalprojectridingshotgun.FinalProjectRidingShotgun.event.entity.Event;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity.GasStations;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.gas.entity.StationOptions;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity.JsonWrapper;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity.Routes;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.User;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.UserRepository;

@SessionAttributes({ "echosen", "user_name" })

public class Calculator {
	@Autowired
	UserRepository userRepo;

	@Value("${maps.key}")
	String map;

	@Value("${gas.key}")
	String gasID;

	public String getDistance(HttpSession session) {
		Event e = (Event) session.getAttribute("echosen");
		System.out.println(e.getLatitude());
		User userOrigin = (User) session.getAttribute("user_name");

		RestTemplate restTemp = new RestTemplate();
		JsonWrapper wrapper = restTemp.getForObject(
				"https://maps.googleapis.com/maps/api/directions/json?origin=" + userOrigin.getAddress()
						+ "&destination="
						+ e.getLatitude() + "," + e.getLongitude() + "&key="
						+ map,
				JsonWrapper.class);

		ArrayList<Routes> routes = wrapper.getRoutes();

		System.out.println("Console: " + routes.get(0).getLegs().get(0).getDistance().getText());
		// System.out.println(response.getBody());

		return "";
	}

	public ModelAndView regGasPrice(HttpSession session) {
		Event e = (Event) session.getAttribute("echosen");

		RestTemplate restTemplate = new RestTemplate();
		GasStations station = restTemplate.getForObject("http://api.mygasfeed.com/stations/radius/" + e.getLatitude()
				+ "/" + e.getLongitude() + "/1.0/reg/price/" + gasID + ".json", GasStations.class);
		ArrayList<StationOptions> priceForCost = station.getChosenStation();
		priceForCost.get(priceForCost.size() - 1).getGasPrice();

		// return new ModelAndView("index", "price",
		// station.getStationDetails().getGasPrice());
		return new ModelAndView("view-event", "price", priceForCost.get(priceForCost.size() - 1).getGasPrice());
	}

}
