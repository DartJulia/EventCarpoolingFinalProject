package com.finalprojectridingshotgun.FinalProjectRidingShotgun;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

//import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.Ride;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.RideRepository;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.User;
import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.UserRepository;

@Controller
@SessionAttributes({ "echosen", "sessionUser", "milesParse" })
public class ShotgunController {

	HttpSession session;

	@Value("${maps.key}")
	String map;

	@Value("${gas.key}")
	String gasID;

	@Autowired
	UserRepository userRepo;

	@Autowired
	RideRepository rideRepo;

// **Takes user to register form 
	@RequestMapping("/registerpage")
	public ModelAndView registrationPage() {
		return new ModelAndView("registration");
	}


	// **Adds new user into User table in database
	//Takes information from registration.jsp and send it to the login page
	
	// Note: Don't need to pass in variables to url (based on jsp form names
	// matching POJO
	// variable names pass object in as parameter and save to database
	
	// Getting information from the registration and saving to DB. sending the user to the login
	@PostMapping("/adduser")
	public ModelAndView addUser(User u) {
		System.out.println(u);
		userRepo.save(u);
		return new ModelAndView("redirect:/login");
		//return new ModelAndView("index", "welcome", "Welcome ");
	}


	// Displays login page
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}

	// Validating login
	// taking information from login.jsp and validating it
	@PostMapping("validateuser")
	public ModelAndView valUserName(@RequestParam("user_name") String username,
			@RequestParam("password") String password, HttpSession session) {
		// userRepo.findByUsernameAndPasscode(username, password).getUser_id();
		Optional<User> user = userRepo.findByUsernameAndPasscode(username, password);
		// System.out.println("Welcome" + user.getFirst_name());
		if (user.isPresent()) {
			String truePassword = user.get().getPasscode();
			if (truePassword.equals(password)) {
				User trueUser = user.get();
				session.setAttribute("sessionUser", trueUser);
				return new ModelAndView("index", "welcome", "Welcome "); // user.get().getFirst_name()
			}
		} else {
			return new ModelAndView("index", "welcome", "you are not a user");
		}
		return null;
	}


}
