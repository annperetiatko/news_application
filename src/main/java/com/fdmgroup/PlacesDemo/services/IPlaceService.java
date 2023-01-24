package com.fdmgroup.PlacesDemo.services;

import java.util.List;

import com.fdmgroup.PlacesDemo.model.Place;

public interface IPlaceService {
	List<Place> findAllPlaces();
	void createNewPlace(Place place);
	Place findPlaceById(int id);
	void deletePlace(int id);
	List<Place> filterPlaces(String filter);
}
