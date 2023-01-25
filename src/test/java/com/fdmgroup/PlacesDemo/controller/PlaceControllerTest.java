package com.fdmgroup.PlacesDemo.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fdmgroup.PlacesDemo.PlacesDemoApplication;
import com.fdmgroup.PlacesDemo.exception.PlaceNotFoundException;
import com.fdmgroup.PlacesDemo.model.Place;
import com.fdmgroup.PlacesDemo.services.IPlaceService;
import com.fdmgroup.PlacesDemo.services.PlaceService;


@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = PlacesDemoApplication.class)
public class PlaceControllerTest {
	
	@MockBean
	private PlaceService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	//@WithMockUser
	public void test_goToIndex_statusOk() throws Exception {
		List<Place> expectedPlaceList = new ArrayList<>();
		expectedPlaceList.add(new Place("Frankfurt", "Germany"));
		
		when(service.findAllPlaces()).thenReturn(expectedPlaceList);
		
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("places", expectedPlaceList))
				.andExpect(view().name("index"));
	}
	
	@Test
	public void test_createNewPlace() throws Exception {
		Place place = new Place("Frankfurt", "Germany");
		
		mockMvc.perform(post("/").param("city", "Frankfurt").param("country", "Germany"))
				.andExpect(status().isOk())
				.andExpect(view().name("index"));
		
		verify(service, times(1)).createNewPlace(place);
	}
	
	@Test
	@WithMockUser
	public void test_goToDetails_statusOK_placesAddedToModel_detailsViewShown() throws Exception {
		Place expectedPlace = new Place("Frankfurt", "Germany");
		when(service.findPlaceById(1)).thenReturn(expectedPlace);
		
		mockMvc.perform(get("/places/1"))
			.andExpect(status().isOk())
			.andExpect(view().name("details"))
			.andExpect(model().attribute("place", expectedPlace));
	}
	
	@Test
	@WithMockUser
	public void test_goToDetails_statusNotFound_throwsPlaceNotFoundException_messageAddedToModel_placeNotFoundViewShown() throws Exception {
		when(service.findPlaceById(123)).thenThrow(new PlaceNotFoundException(123));
		
		mockMvc.perform(get("/places/123"))
			.andExpect(status().isNotFound())
			.andExpect(result -> assertTrue(result.getResolvedException() instanceof PlaceNotFoundException))
			.andExpect(view().name("notFound"))
			.andExpect(model().attribute("message", "The place with id 123 could not be found."))
			.andExpect(model().attribute("type", "place"));
	}
}
