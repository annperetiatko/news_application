package com.fdmgroup.news.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserProfileTest {
	
	@Test
	void testUserProfileCreation() {
		UserProfile userProfile = new UserProfile();
		assertNotNull(userProfile);
	}

}
