package com.finalprojectridingshotgun.FinalProjectRidingShotgun;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.Ride;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.RideRepository;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.User;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.UserRepository;

@Controller
@SessionAttributes("user_name")
public class ShotgunController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RideRepository rideRepo;
	
// **Takes user to register form 
	@RequestMapping("/registerpage")
	public ModelAndView registrationPage() {
		return new ModelAndView("registration");
	}

//	@RequestMapping("/ridesearch")
//	public ModelAndView riderOptionPage() {
//		return new ModelAndView("ridesearch");
//	}
//	
	// **Adds new user into User table in database
	// Note: Don't need to pass in variables to url (based on jsp form names
	// matching POJO
	// variable names pass object in as parameter and save to database
	@RequestMapping("/adduser")
	public ModelAndView addUser(User u) {
		System.out.println(u);
		userRepo.save(u);
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping("/pullevent/{id}/{title}")
	public ModelAndView pullEvent(@PathVariable("id") String id, @PathVariable("title") String title) {
		
		Ride eventIdAndTitleToAdd = new Ride(id, title, 1);
		System.out.println(eventIdAndTitleToAdd.getEventid());
		System.out.println(eventIdAndTitleToAdd.getEventtitle());
		rideRepo.save(eventIdAndTitleToAdd);
		return new ModelAndView ("redirect:/");
	}

	//Displays login page
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}

	//Validating login
	@RequestMapping ("validateuser")
	public ModelAndView valUserName(@RequestParam("user_name") String username,
			@RequestParam("password") String password, HttpSession session) {
		// userRepo.findByUsernameAndPasscode(username, password).getUser_id();
	User user = userRepo.findByUsernameAndPasscode(username, password);
	session.setAttribute("user_name", user);
	System.out.println("Welcome" + user.getFirst_name());
		return new ModelAndView("index", "welcome", "Welcome " + user.getFirst_name() + "!");
	}	

	
//	@RequestMapping("/pullevent")
//	public ModelAndView pullEvent() {
//		Event eventIdToAdd = new;
//		eventIdToAdd.getId();
//		Event eventTitleToAdd = new Event();
//		eventTitleToAdd.getTitle();
//		System.out.println(eventIdToAdd + " " + eventTitleToAdd);
//		return new ModelAndView("redirect:/");
//	}
	
//	@RequestMapping("/sendevent")
//	public ModelAndView sendEventToDatabase(Event ) {
//		
//		
//		System.out.println(eventToAdd);
//		return new ModelAndView("redirect:/");
//	}
	
	

}
