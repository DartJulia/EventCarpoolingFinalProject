package com.finalprojectridingshotgun.FinalProjectRidingShotgun;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity.JsonWrapper;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity.Routes;

@Controller
public class MapsController {

	@Value("${maps.key}")
	String map;



	@RequestMapping("/search")
	public ModelAndView searchTitle() {

		RestTemplate restTemp = new RestTemplate();
		JsonWrapper wrapper = restTemp.getForObject(
				"https://maps.googleapis.com/maps/api/directions/json?origin=41.8781,-87.6298&destination=39.007504,-94.529625&key="
						+ map,
				JsonWrapper.class);

		ArrayList<Routes> routes = wrapper.getRoutes();

		System.out.println("Console: " + routes.get(0).getLegs().get(0).getDistance().getText());
		// System.out.println(response.getBody());
		return new ModelAndView("result", "map", routes.get(0).getLegs().get(0).getDistance().getText());
	}

}
