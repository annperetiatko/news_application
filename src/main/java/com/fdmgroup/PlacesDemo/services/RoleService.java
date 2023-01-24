package com.fdmgroup.PlacesDemo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.PlacesDemo.model.Role;
import com.fdmgroup.PlacesDemo.repository.RoleRepository;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository repo;
	
	@Override
	public Role findByRoleName(String roleName) {
		Optional<Role> optRole = repo.findByRoleName(roleName);
		
		return optRole.orElse(new Role("default role"));
	}

}
