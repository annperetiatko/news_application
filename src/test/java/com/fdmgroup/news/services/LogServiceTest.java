package com.fdmgroup.news.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ModelMap;

import com.fdmgroup.news.model.User;
import com.fdmgroup.news.security.DefaultUserDetailsService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

@AutoConfigureMockMvc
public class LogServiceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	DefaultUserDetailsService mockUserService;
	
	@MockBean
	PasswordEncoder encoder;
	
	@InjectMocks
	LogService logService;
	
	User testUser = new User();
	
	private void mockAuthentication() {
		testUser.setFirstName("testUser");
		testUser.setId(1);
	}
	
	@Test
	@WithMockUser(username = "testUser", authorities = { "User" })
	public void isLoggedIn_fillingModel_withNoAssignedRoles() {
		mockAuthentication();
		ModelMap mockModel = mock(ModelMap.class);
		
//		assertTrue(logService.isLoggedIn(mockModel));
//		verify(mockModel).addAttribute("username", "testUser");
//		verify(mockModel).addAttribute("roleList","");
	}
	
	@Test
	public void isLoggedIn_fillingModel_returnsFalse_whenNotLoggedIn() {
		ModelMap mockModel = mock(ModelMap.class);
		assertFalse(logService.isLoggedIn(mockModel));
	}
}
