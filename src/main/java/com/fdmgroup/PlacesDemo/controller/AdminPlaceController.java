package com.fdmgroup.PlacesDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fdmgroup.PlacesDemo.exception.PlaceNotFoundException;
import com.fdmgroup.PlacesDemo.services.IPlaceService;

@Controller
public class AdminPlaceController {

	@Autowired
	private IPlaceService service;
	
	@GetMapping(value = "/admin/{id}")
	public String goToDetails(ModelMap model, @PathVariable int id) throws PlaceNotFoundException{
		model.addAttribute("place", service.findPlaceById(id));
		return "details";
	}

}
