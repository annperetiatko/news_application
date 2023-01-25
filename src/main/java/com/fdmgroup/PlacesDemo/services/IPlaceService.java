package com.fdmgroup.PlacesDemo.services;

import java.util.List;

import com.fdmgroup.PlacesDemo.exception.PlaceNotFoundException;
import com.fdmgroup.PlacesDemo.model.Place;

public interface IPlaceService {
	List<Place> findAllPlaces();
	void createNewPlace(Place place);
	Place findPlaceById(int id) throws PlaceNotFoundException;
	void deletePlace(int id) throws PlaceNotFoundException;
	List<Place> filterPlaces(String filter);
}
