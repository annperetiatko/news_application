package com.fdmgroup.PlacesDemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.PlacesDemo.model.User;
import com.fdmgroup.PlacesDemo.security.DefaultUserDetailsService;
import com.fdmgroup.PlacesDemo.services.PlaceService;
import com.fdmgroup.PlacesDemo.services.RoleService;



@Controller
public class LoginAndRegisterController {

	@Autowired
	private DefaultUserDetailsService userService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private PlaceService placeService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerSubmit(@ModelAttribute("user")User user, ModelMap model) {
		Optional<User> userFromDatabase = userService.findByUsername(user.getUsername());
		if (userFromDatabase.isPresent()) {
			model.addAttribute("message", "This user name already exists");
			return "register";
		}
		
		user.setRole(roleService.findByRoleName("Customer"));
		user.setPassword(encoder.encode(user.getPassword()));
		userService.saveUser(user);
		model.addAttribute("places", placeService.findAllPlaces());
		return "index";
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ModelAndView handleUsernameNotFoundException(UsernameNotFoundException ex) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notFound");
		mav.addObject("type", "user");
		mav.addObject("message", ex.getMessage());
		return mav;
	}
}
