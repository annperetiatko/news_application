package com.fdmgroup.PlacesDemo.controller.test;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fdmgroup.PlacesDemo.controller.PlaceController;
import com.fdmgroup.PlacesDemo.model.Place;
import com.fdmgroup.PlacesDemo.services.IPlaceService;


@SpringBootTest(classes = {PlaceController.class})
@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class PlaceControllerTest {
	
	@MockBean
	private IPlaceService service;
	
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
}
