package com.fdmgroup.PlacesDemo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fdmgroup.PlacesDemo.model.User;
import com.fdmgroup.PlacesDemo.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetails details;
		Optional<User> optUser = repo.findByUsername(username);
		if (optUser.isPresent())
			details = new UserPrincipal(optUser.get());
		else
			throw new UsernameNotFoundException(username);
		return details;

	}

}
