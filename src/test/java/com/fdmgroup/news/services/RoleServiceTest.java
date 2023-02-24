package com.fdmgroup.news.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import com.fdmgroup.news.model.Role;
import com.fdmgroup.news.repository.RoleRepository;

public class RoleServiceTest {
	
	private RoleService roleService;
	private RoleRepository repoMock;
	
//	@Before
//	public void setup() {
//		repoMock = mock(RoleRepository.class);
//		roleService = new RoleService();
//		roleService.repo = repoMock;
//	}

	@Test
	public void testFindByRoleNameWithValidRole() {
		String roleName = "ROLE_ADMIN";
		Role role = new Role(roleName);

//		when(repoMock.findByRoleName(roleName)).thenReturn(Optional.of(role));
//
//		Role result = roleService.findByRoleName(roleName);
//
//		assertEquals(role, result);
	}

	@Test
	public void testFindByRoleNameWithNonExistingRole() {
		String roleName = "ROLE_NONEXISTENT";

//		when(repoMock.findByRoleName(roleName)).thenReturn(Optional.empty());
//
//		Role result = roleService.findByRoleName(roleName);
//
//		assertEquals("default role", result.getRoleName());
	}

}
