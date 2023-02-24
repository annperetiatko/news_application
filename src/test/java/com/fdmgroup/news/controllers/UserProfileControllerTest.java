package com.fdmgroup.news.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fdmgroup.news.controller.UserProfileController;
import com.fdmgroup.news.model.User;
import com.fdmgroup.news.security.DefaultUserDetailsService;
import com.fdmgroup.news.services.LogService;


public class UserProfileControllerTest {
	
	private MockMvc mockMvc;
    private DefaultUserDetailsService userService;
    private LogService login;

    @BeforeEach
    public void setup() {
        userService = mock(DefaultUserDetailsService.class);
        login = mock(LogService.class);
    }

    @Test
    public void testEditUserDetailsPage() throws Exception {
        // mock the logged-in user
        User user = new User();
        user.setUsername("john");
        user.setFirstName("John");
        user.setSurName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPhoneNumber("+1-555-1234567");

//        when(login.getLoggedUser()).thenReturn(user);
//
//        mockMvc.perform(get("/editProfile"))
//            .andExpect(status().isOk())
//            .andExpect(view().name("editProfile"))
//            .andExpect(model().attribute("user", user));
    }
   

    @Test
    public void testShowUserDetails() throws Exception {
        // mock the logged-in user
        User user = new User();
        user.setUsername("john");
        user.setFirstName("John");
        user.setSurName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPhoneNumber("+1-555-1234567");

//        when(login.getLoggedUser()).thenReturn(user);
//
//        mockMvc.perform(get("/userProfile"))
//            .andExpect(status().isOk())
//            .andExpect(view().name("userProfile"))
//            .andExpect(model().attribute("userName", user.getUsername()))
//            .andExpect(model().attribute("userFirstName", user.getFirstName()))
//            .andExpect(model().attribute("userSurName", user.getSurName()))
//            .andExpect(model().attribute("userEmail", user.getEmail()))
//			.andExpect(model().attribute("userPhone", user.getPhoneNumber()));       
    }
    
    @Test
	public void testEditUserDetails() throws Exception {
		User testUser = new User();
		testUser.setUsername("testuser");
		testUser.setFirstName("Test");
		testUser.setSurName("User");
		testUser.setEmail("testuser@test.com");
		testUser.setPhoneNumber("1234567890");

//		when(login.getLoggedUser()).thenReturn(testUser);
//		when(userService.saveUser(testUser)).thenReturn(testUser);
//
//		mockMvc.perform(post("/editProfile")
//				.param("firstName", "New First Name")
//				.param("surName", "New SurName")
//				.param("email", "newemail@test.com")
//				.param("phoneNumber", "0987654321"))
//			.andExpect(status().isOk())
//			.andExpect(view().name("userProfile"))
//			.andExpect(model().attribute("userName", testUser.getUsername()))
//			.andExpect(model().attribute("userFirstName", "New First Name"))
//			.andExpect(model().attribute("userSurName", "New SurName"))
//			.andExpect(model().attribute("userEmail", "newemail@test.com"))
//			.andExpect(model().attribute("userPhone", "0987654321"));

//		verify(login).isLoggedIn(modelAndViewCaptor.capture());
	}
}


