package com.fdmgroup.PlacesDemo.services;

import com.fdmgroup.PlacesDemo.model.Role;

public interface IRoleService {
	Role findByRoleName(String roleName);
}
