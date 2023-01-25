package com.fdmgroup.PlacesDemo.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fdmgroup.PlacesDemo.repository.PlaceRepository;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class PlaceServiceTest {
	
	@InjectMocks
	PlaceService service;
	
	@MockBean
	PlaceRepository mockRepo;
	
	@Test
	public void test_findAllPlaces() {
		service.findAllPlaces();
		verify(mockRepo, times(1)).findAll();
	}
}
