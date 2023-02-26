package com.fdmgroup.news.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fdmgroup.news.model.User;
import com.fdmgroup.news.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@Test
	public void testFindByUsername() {
		String username = "test_user";
		User user = new User("test_user");

		when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));
		User result = userService.findByUsername(username);

		assertThat(result).isEqualTo(user);
	}

	@Test
	public void testFindByUserId() {
		int id = 123;
		User user = new User("test_user");

		when(userRepository.findByUserId(id)).thenReturn(Optional.of(user));
		User result = userService.findByUserId(id);

		assertThat(result).isEqualTo(user);
	}
}

