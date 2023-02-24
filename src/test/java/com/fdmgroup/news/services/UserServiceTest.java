package com.fdmgroup.news.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.news.model.User;
import com.fdmgroup.news.repository.UserRepository;

public class UserServiceTest {
	
	 private UserService userService;

	    @Mock
	    private UserRepository mockUserRepository;

//	    @Before
//	    public void setUp() {
//	        MockitoAnnotations.initMocks(this);
//	        userService = new UserService();
//	        userService.repo = mockUserRepository;
//	    }

	    @Test
	    public void testFindByUsername() {
	        User mockUser = new User();
	        mockUser.setFirstName("John");
	        mockUser.setSurName("Doe");
	        mockUser.setEmail("john.doe@example.com");
	        mockUser.setUsername("johndoe");

//	        when(mockUserRepository.findByUsername(anyString())).thenReturn(Optional.of(mockUser));
//
//	        User result = userService.findByUsername("johndoe");
//
//	        assertNotNull(result);
//	        assertEquals("John", result.getFirstName());
//	        assertEquals("Doe", result.getSurName());
//	        assertEquals("john.doe@example.com", result.getEmail());
//	        assertEquals("johndoe", result.getUsername());
	    }

	    @Test
	    public void testFindByUserId() {
	        User mockUser = new User();
	        mockUser.setFirstName("John");
	        mockUser.setSurName("Doe");
	        mockUser.setEmail("john.doe@example.com");
	        mockUser.setUsername("johndoe");

//	        when(mockUserRepository.findByUserId(anyInt())).thenReturn(Optional.of(mockUser));
//
//	        User result = userService.findByUserId(1);
//
//	        assertNotNull(result);
//	        assertEquals("John", result.getFirstName());
//	        assertEquals("Doe", result.getSurName());
//	        assertEquals("john.doe@example.com", result.getEmail());
//	        assertEquals("johndoe", result.getUsername());
	    }

}
