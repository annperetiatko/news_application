package com.fdmgroup.PlacesDemo.exception;

public class PlaceNotFoundException extends Exception {
	public PlaceNotFoundException(int placeId) {
		super("The place with id " + placeId + " could not be found.");
	}
}
