package com.fdmgroup.PlacesDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.PlacesDemo.exception.PlaceNotFoundException;
import com.fdmgroup.PlacesDemo.model.Place;
import com.fdmgroup.PlacesDemo.repository.PlaceRepository;

@Service
public class PlaceService implements IPlaceService {

	@Autowired
	private PlaceRepository repo;

	@Override
	public List<Place> findAllPlaces() {
		return repo.findAll();
	}

	@Override
	public void createNewPlace(Place place) {
		repo.save(place);
	}

	@Override
	public Place findPlaceById(int id) {
		Optional<Place> optPlace = repo.findById(id);
		//return optPlace.orElse(new Place("default-city", "default-country"));
		return optPlace.orElseThrow(() -> new PlaceNotFoundException(id));
//		if (optPlace.isPresent()) {
//			return optPlace.get();
//		} else {
//			throw new PlaceNotFoundException(id);
//		}
	}

	@Override
	public List<Place> filteredPlacesByCountry(String country) {
		return repo.findByCountryContains(country);
	}
	
	@Override
	public List<Place> filterPlacesByCity(String filteredCity) {
		return repo.findByCity(filteredCity);
	}

	@Override
	public void deletePlace(int id) {
		repo.delete(findPlaceById(id));	
	}

}
