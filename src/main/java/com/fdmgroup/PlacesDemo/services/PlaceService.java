package com.fdmgroup.PlacesDemo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return optPlace.orElse(new Place("default-city", "default-country"));

	}


	@Override
	public void deletePlace(int id) {
		repo.delete(findPlaceById(id));	
	}

	@Override
	public List<Place> filterPlaces(String filter) {
		List<Place> filteredByCity = repo.findByCityIgnoreCaseContaining(filter);
		List<Place> filteredByCountry = repo.findByCountryIgnoreCaseContaining(filter);
		
		filteredByCity.addAll(filteredByCountry);
		List<Place> filteredPlaces = filteredByCity.stream().distinct().collect(Collectors.toList());
		return filteredPlaces;
	}

}
