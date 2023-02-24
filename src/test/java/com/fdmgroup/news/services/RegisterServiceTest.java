package com.fdmgroup.news.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;

import com.fdmgroup.news.model.User;
import com.fdmgroup.news.security.DefaultUserDetailsService;


public class RegisterServiceTest {

	private RegisterService registerService;
	private DefaultUserDetailsService userServiceMock;
	private PasswordEncoder encoderMock;
	
//	@Before
//	public void setup() {
//		userServiceMock = mock(DefaultUserDetailsService.class);
//		encoderMock = mock(PasswordEncoder.class);
//		registerService = new RegisterService();
//		registerService.userService = userServiceMock;
//		registerService.encoder = encoderMock;
//	}

	@Test
	public void testRegisterSubmitWithValidUser() {
		User user = new User();
		user.setUsername("johndoe");
		user.setPassword("password");
		String confirmPassword = "password";
		ModelMap model = new ModelMap();

//		when(userServiceMock.findByUsername(user.getUsername())).thenReturn(Optional.empty());
//		when(encoderMock.encode(user.getPassword())).thenReturn("encodedPassword");
//
//		String viewName = registerService.registerSubmit(user, confirmPassword, model);
//		assertEquals("index", viewName);
	}

	@Test
	public void testRegisterSubmitWithExistingUser() {
		User user = new User();
		user.setUsername("johndoe");
		user.setPassword("password");
		String confirmPassword = "password";
		ModelMap model = new ModelMap();

//		when(userServiceMock.findByUsername(user.getUsername())).thenReturn(Optional.of(user));
//
//		String viewName = registerService.registerSubmit(user, confirmPassword, model);
//		assertEquals("register", viewName);
//		assertEquals("This user name already exists", model.get("message"));
	}

	@Test
	public void testRegisterSubmitWithNonMatchingPasswords() {
		User user = new User();
		user.setUsername("johndoe");
		user.setPassword("password");
		String confirmPassword = "differentPassword";
		ModelMap model = new ModelMap();

//		when(userServiceMock.findByUsername(user.getUsername())).thenReturn(Optional.empty());
//
//		String viewName = registerService.registerSubmit(user, confirmPassword, model);
//		assertEquals("register", viewName);
//		assertEquals("Passwords do not match", model.get("message"));
//	}
}
}
