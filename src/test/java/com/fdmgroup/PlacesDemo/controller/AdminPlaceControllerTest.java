package com.fdmgroup.PlacesDemo.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fdmgroup.PlacesDemo.PlacesDemoApplication;
import com.fdmgroup.PlacesDemo.model.Place;
import com.fdmgroup.PlacesDemo.services.PlaceService;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = PlacesDemoApplication.class)
public class AdminPlaceControllerTest {
	
	@MockBean
	PlaceService service;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	@WithMockUser(roles = "Admin")
	public void test_goToDetails_withAdminRole_addedPlaceToModel_showDetailsView() throws Exception {
		Place expectedPlace = new Place("Frankfurt", "Germany");
		when(service.findPlaceById(1)).thenReturn(expectedPlace);
		
		mockMvc.perform(get("/admin/1"))
			.andExpect(status().isOk())
			.andExpect(view().name("details"))
			.andExpect(model().attribute("place", expectedPlace));
	}
}
