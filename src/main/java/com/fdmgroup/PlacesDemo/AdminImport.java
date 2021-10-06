package com.fdmgroup.PlacesDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.fdmgroup.PlacesDemo.model.Role;
import com.fdmgroup.PlacesDemo.model.User;
import com.fdmgroup.PlacesDemo.repository.UserRepository;


@Component
public class AdminImport implements ApplicationRunner {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepo;


	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (!userRepo.findByUsername("admin").isPresent()) {
			User admin = new User();
			Role roleAdmin = new Role();
			roleAdmin.setRoleName("Admin");

			admin.setUsername("admin");
			admin.setPassword(encoder.encode("123"));
			admin.setRole(roleAdmin);

			User nonadmin = new User("nonadmin", encoder.encode("123"));

			userRepo.save(admin);
			userRepo.save(nonadmin);
		}

	}


}
