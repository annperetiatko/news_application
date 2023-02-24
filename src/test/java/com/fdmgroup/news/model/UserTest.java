package com.fdmgroup.news.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserTest {
	
	@Test
	public void testUserCreation() {
		User user = new User("johndoe", "password", "johndoe@example.com", "John", "Doe", "1234567890");
		user.setRoleList(Arrays.asList(new Role("USER")));
		assertEquals("johndoe", user.getUsername());
		assertEquals("password", user.getPassword());
		assertEquals("johndoe@example.com", user.getEmail());
		assertEquals("John", user.getFirstName());
		assertEquals("Doe", user.getSurName());
		assertEquals("1234567890", user.getPhoneNumber());
		assertEquals(1, user.getRoleList().size());
		assertEquals("ROLE_USER", user.getRoleList().get(0).getAuthority());
	}

	@Test
	public void testUserEquality() {
		User user1 = new User("johndoe", "password", "johndoe@example.com", "John", "Doe", "1234567890");
		user1.setRoleList(Arrays.asList(new Role("USER")));
		User user2 = new User("johndoe", "password", "johndoe@example.com", "John", "Doe", "1234567890");
		user2.setRoleList(Arrays.asList(new Role("USER")));
		User user3 = new User("janedoe", "password", "janedoe@example.com", "Jane", "Doe", "0987654321");
		user3.setRoleList(Arrays.asList(new Role("USER")));
		assertTrue(user1.equals(user2));
		assertFalse(user1.equals(user3));
	}


	
}
