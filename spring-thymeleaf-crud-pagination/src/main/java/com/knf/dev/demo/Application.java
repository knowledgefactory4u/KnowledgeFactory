package com.knf.dev.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.knf.dev.demo.domain.User;
import com.knf.dev.demo.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Insert dummy users
		User user1 = new User("Alpha", "Pro", "alpha@knf.net");
		User user2 = new User("Beta", "Pro", "beta@knf.net");
		User user3 = new User("Gama", "Gama Pro", "gama@knf.net");
		User user4 = new User("Pekka", "pekka", "pekka@knf.net");
		User user5 = new User("Tesla", "Pro", "tesla@knf.net");
		User user6 = new User("Xray", "Noob", "xray@knf.net");
		User user7 = new User("Tera", "noob", "tera@knf.net");
		User user8 = new User("Bot", "noob", "alpha@knf.net");
		User user9 = new User("Pro", "pro", "pro@knf.net");
		List<User> users = Arrays.asList(user1, user2, user3, user4, user9, user8, user7, user6, user5);
		repository.saveAll(users);
	}

}
