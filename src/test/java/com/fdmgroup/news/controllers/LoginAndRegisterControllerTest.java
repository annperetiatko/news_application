package com.fdmgroup.news.controllers;

import com.fdmgroup.news.controller.LoginAndRegisterController;
import com.fdmgroup.news.model.User;
import com.fdmgroup.news.services.LogService;
import com.fdmgroup.news.services.RegisterService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class LoginAndRegisterControllerTest {
	
	 @Mock
	    private LogService logService;

	    @Mock
	    private RegisterService registerService;

	    @InjectMocks
	    private LoginAndRegisterController controller;

	    @Test
	    void testLogin() {
	        ModelMap model = new ModelMap();

	        String result = controller.login(model);

	        assertEquals("login", result);
	        verify(logService).isLoggedIn(model);
	    }

	    @Test
	    void testRegister() {
	        ModelMap model = new ModelMap();

	        String result = controller.register(model);

	        assertEquals("register", result);
	        verify(logService).isLoggedIn(model);
	    }

	    @Test
	    void testRegisterSubmit() {
	        User user = new User();
	        String confirmPassword = "password";
	        ModelMap model = new ModelMap();

	        when(registerService.registerSubmit(user, confirmPassword, model)).thenReturn("success");

	        String result = controller.registerSubmit(user, confirmPassword, model);

	        assertEquals("success", result);
	        verify(registerService).registerSubmit(user, confirmPassword, model);
	    }

	    @Test
	    void testHandleUsernameNotFoundException() {
	        UsernameNotFoundException ex = new UsernameNotFoundException("User not found");

	        ModelAndView mav = controller.handleUsernameNotFoundException(ex);

	        assertEquals("notFound", mav.getViewName());
	        assertEquals("user", mav.getModel().get("type"));
	        assertEquals("User not found", mav.getModel().get("message"));
	        
	    }

}
