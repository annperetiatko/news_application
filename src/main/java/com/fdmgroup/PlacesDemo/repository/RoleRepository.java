package com.fdmgroup.PlacesDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.PlacesDemo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
