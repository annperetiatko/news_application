package com.fdmgroup.PlacesDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fdmgroup.PlacesDemo.model.Place;
@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

	List<Place> findByCountryIgnoreCaseContaining(String filter);
	List<Place> findByCityIgnoreCaseContaining(String filter);

}
