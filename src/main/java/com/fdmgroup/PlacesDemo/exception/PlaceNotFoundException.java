package com.fdmgroup.PlacesDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PlaceNotFoundException extends RuntimeException {
	public PlaceNotFoundException(int id) {
		super("The place with id " + id + " could not be found.");
	}
}
