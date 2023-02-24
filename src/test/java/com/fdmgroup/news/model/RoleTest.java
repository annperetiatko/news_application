package com.fdmgroup.news.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoleTest {
	
	  @Test
	    public void testGetAuthority() {
	        Role role = new Role("ADMIN");
	        Assertions.assertEquals("ROLE_ADMIN", role.getAuthority());
	    }

//	    @Test
//	    public void testEquals() {
//	        Role role1 = new Role("USER 1");
//	        Role role2 = new Role("USER 2");
//	        Role role3 = new Role("ADMIN");
//	        Assertions.assertEquals(role1, role2);
//	        Assertions.assertNotEquals(role1, role3);
//	    }


}
