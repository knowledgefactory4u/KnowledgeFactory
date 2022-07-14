package com.knf.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.knf.dev.models.ERole;
import com.knf.dev.models.Role;
import com.knf.dev.repository.RoleRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*
	 * Add some rows into roles collection before assigning any role to Employee.
	 */
	@Override
	public void run(String... args) throws Exception {
		try {
			if (roleRepository.findAll().isEmpty()) {
				Role role = new Role();
				role.setName(ERole.ROLE_EMPLOYEE);
				roleRepository.save(role);
				Role role2 = new Role();
				role2.setName(ERole.ROLE_ADMIN);
				roleRepository.save(role2);
			} else {

			}
		} catch (Exception e) {

		}
	}

}
