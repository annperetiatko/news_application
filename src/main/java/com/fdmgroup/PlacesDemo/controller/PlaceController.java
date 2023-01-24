package com.fdmgroup.PlacesDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.PlacesDemo.model.Place;
import com.fdmgroup.PlacesDemo.services.IPlaceService;

@Controller
public class PlaceController {
	
	@Autowired
	private IPlaceService service;
	
//	List<Place> placeList = new ArrayList<Place>();
	
//	@RequestMapping(method=RequestMethod.GET, value="/")
	@GetMapping(value="/")
	public String goToIndex(ModelMap model) {
//		placeList.clear();
//		Place place = new Place("Frankfurt", "DE");
//		Place place2 = new Place("Warsaw", "Poland");
//		Place place3 = new Place("New Delhi", "India");
//		placeList.add(place);
//		placeList.add(place2);
//		placeList.add(place3);
//		model.addAttribute("places", placeList);
		populateModel(model);
		return "index";
	}
	@PostMapping(value="/")
//	public String createNewPlace(ModelMap model, @RequestParam String city, @RequestParam(name="country") String placeCountry) {
	public String createNewPlace(ModelMap model, @ModelAttribute Place place) {
//		Place place = new Place(city, placeCountry);
//		placeList.add(place);
//		model.addAttribute("places", placeList);
		service.createNewPlace(place);
		populateModel(model);
		return "index";
	}
	
	@GetMapping(value="/places/{id}")
	public String goToDetails(ModelMap model, @PathVariable int id) {
		model.addAttribute("place", service.findPlaceById(id));
		return "details";
	}
	
	@PostMapping("/delete")
	public String deletePlace(ModelMap model, @RequestParam int id) {
		service.deletePlace(id);
		populateModel(model);
		return "index";
	}
	
	@PostMapping("/filtered")
	public String filterPlaces(ModelMap model, @RequestParam String filter) {
		List<Place> filteredPlaces = service.filterPlaces(filter);
		
		model.addAttribute("filteredPlaces", filteredPlaces);
		populateModel(model);
		return "index";
	}
	
	private void populateModel(ModelMap model) {
		model.addAttribute("places", service.findAllPlaces());
	}
}
