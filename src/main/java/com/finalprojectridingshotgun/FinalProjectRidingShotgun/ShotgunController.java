package com.finalprojectridingshotgun.FinalProjectRidingShotgun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.User;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.UserRepository;

@Controller
public class ShotgunController {
	
	@Autowired
	UserRepository userRepo;

	@RequestMapping("/registerpage")
	public ModelAndView registrationPage() {
		return new ModelAndView("registration");
	}
	
	// @RequestMapping("/adduser/{first_name}/{last_name}/{email}/{address}/{username}/{passcode}")
	@RequestMapping("/adduser")
//	public ModelAndView addUser(@PathVariable("first_name") String fName, @PathVariable("last_name") String lName,
//			@PathVariable("email") String email, @PathVariable("address") String city,
//			@PathVariable("username") String userName, @PathVariable("passcode") String password) {
	public ModelAndView addUser(User u) {
		System.out.println(u);
		userRepo.save(u);
		// System.out.println(fName + lName);
		// User user = new User(fName, lName, userName, password, city, email);
//		userRepo.save(user);
//		System.out.println(user);
		return new ModelAndView("redirect:/");
	}

}
