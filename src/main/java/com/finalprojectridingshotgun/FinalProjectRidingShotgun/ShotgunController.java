package com.finalprojectridingshotgun.FinalProjectRidingShotgun;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.finalprojectridingshotgun.FinalProjectRidingShotgun.repo.Ride;
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
	// Note: Don't need to pass in variables to url (based on jsp form names
	// matching POJO
	// variable names pass object in as parameter and save to database
	@RequestMapping("/adduser")
	public ModelAndView addUser(User u) {
		System.out.println(u);
		userRepo.save(u);
		return new ModelAndView("index", "welcome", "Welcome ");
	}
	// Where is this going?
	@RequestMapping("/pullevent/{id}/{title}")
	public ModelAndView pullEvent(@PathVariable("id") String id, @PathVariable("title") String title,
			HttpSession session) {
		User user = (User) session.getAttribute("sessionUser");
		// System.out.println(user.getFirst_name());
		Ride eventIdAndTitleToAdd = new Ride(id, title, user.getUser_id());
		//System.out.println(eventIdAndTitleToAdd.getEventid());
		//System.out.println(eventIdAndTitleToAdd.getEventtitle());
		rideRepo.save(eventIdAndTitleToAdd);
		return new ModelAndView("redirect:/");
	}

	// Displays login page
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}

	// Validating login
	@RequestMapping("validateuser")
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



//
//	@RequestMapping("test")
//	public String test() {
//		return "test";
//	}
////
//	@RequestMapping("finddistance")
//	public ModelAndView findDistance(HttpSession session) {
//		// Double milesParse = milesParsed(session);
//		// tripCost = (milesParse/mpg) * pfc;
////		GasController.gaspriceatloc(e, milesParse);
//		// System.out.println(userOrigin);
//		// return new ModelAndView ("test", "testresult",
//		// tripDistance.getRoutes().get(0).getLegs().get(0).getDistance().getText());
//		User userOrigin = (User) session.getAttribute("sessionUser");
//		Event e = (Event) session.getAttribute("echosen");
//		Double num = findTripDistance(userOrigin, e);
//		System.out.println(num);
////		session.setAttribute("milesParse", milesParse);
////		System.out.println(milesParse);
//		return new ModelAndView("test", "tripDist", "");
//	}



//	public Double milesParsed() {
//
//		User userOrigin = (User) session.getAttribute("sessionUser");
//		Event e = (Event) session.getAttribute("echosen");
//		RestTemplate restTemp = new RestTemplate();
//		JsonWrapper tripDistance = restTemp.getForObject(
//				"https://maps.googleapis.com/maps/api/directions/json?origin=" + userOrigin.getAddress()
//						+ "&destination=" + e.getLatitude() + "," + e.getLongitude() + "&key=AIzaSyAKfsn7d9hrGFAZ8li6w5Fncn-sV0xSlJI",
//				JsonWrapper.class);
//
//		String dist = tripDistance.getRoutes().get(0).getLegs().get(0).getDistance().getText();
//		String[] miles = dist.split(" ");
//		Double milesParse = Double.parseDouble(miles[0]);
//		session.setAttribute("milesParse", milesParse);
//		System.out.println(milesParse);
//		return milesParse;
//	}



}
