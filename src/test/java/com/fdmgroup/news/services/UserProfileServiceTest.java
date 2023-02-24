package com.fdmgroup.news.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.news.model.User;

public class UserProfileServiceTest {
	
	private UserProfileService userProfileService;

    @Mock
    private User mockUser;

//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        userProfileService = new UserProfileService();
//    }
    @BeforeEach
    public void setUp() {
        mockUser = new User();
    }

//    @Test
//    public void testEditUserDetails() {
//        mockUser.setFirstName("John");
//        mockUser.setSurName("Doe");
//        mockUser.setEmail("john.doe@example.com");
//        mockUser.setPassword("password");
//
//        User result = userProfileService.editUserDetails(mockUser);
//
//        assertNotNull(result);
//        assertEquals("John", result.getFirstName());
//        assertEquals("Doe", result.getSurName());
//        assertEquals("john.doe@example.com", result.getEmail());
//        assertEquals("password", result.getPassword());
//    }

//    @Test
//    public void testDisplayUserDetails() {
//        mockUser.setFirstName("John");
//        mockUser.setSurName("Doe");
//        mockUser.setEmail("john.doe@example.com");
//        mockUser.setPassword("password");
//
//        User result = userProfileService.displayUserDetails(mockUser);
//
//        assertNotNull(result);
//        assertEquals("John", result.getFirstName());
//        assertEquals("Doe", result.getSurName());
//        assertEquals("john.doe@example.com", result.getEmail());
//        assertEquals("password", result.getPassword());
//    }

}
