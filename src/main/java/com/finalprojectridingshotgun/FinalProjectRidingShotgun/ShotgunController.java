package com.finalprojectridingshotgun.FinalProjectRidingShotgun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShotgunController {
	
	@RequestMapping("/registerpage")
	public ModelAndView registrationPage() {
		return new ModelAndView("registration");
	}
	
	
	@RequestMapping("/adduser")
	public ModelAndView addUser() {
		
		
		return new ModelAndView("");
	}

}
