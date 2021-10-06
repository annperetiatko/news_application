package com.fdmgroup.PlacesDemo.services;

import java.util.List;

import com.fdmgroup.PlacesDemo.model.Place;

public interface IPlaceService {
	List<Place> findAllPlaces();
	void createNewPlace(Place place);
	Place findPlaceById(int id);
	List<Place> filteredPlacesByCountry(String country);
	List<Place> filterPlacesByCity(String city);
	void deletePlace(int id);
}
