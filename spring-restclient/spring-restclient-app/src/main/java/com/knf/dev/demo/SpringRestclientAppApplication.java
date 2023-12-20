package com.knf.dev.demo;

import com.knf.dev.demo.model.User;
import com.knf.dev.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestclientAppApplication implements CommandLineRunner {


	UserService userService;

	public SpringRestclientAppApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRestclientAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Create User1
		User user = new User();
		user.setAge(19);
		user.setEmail("carl@knf.com");
		user.setName("Carl");
		userService.createUser(user);

		//Create User2
		User user2 = new User();
		user2.setAge(45);
		user2.setEmail("rick@knf.com");
		user2.setName("Rick");
		User userRick = userService.createUser(user2);

		//Update User2
		User _user2 = new User();
		_user2.setAge(47);
		_user2.setEmail("rick2@knf.com");
		_user2.setName("Rick2");
		userService.updateUser(_user2,userRick.getId());

		//Find User2 by Id
		userService.findById(userRick.getId());

		//Find User2 by Id
		userService.findByIdWithExchangeMethod(userRick.getId());

        //Find by Id: Invalid id
		userService.findById(123l);

		//Find by Id: Invalid id
		userService.findByIdWithExchangeMethod(123l);

		//Get all users
		userService.getAllUsers();

		//Get all users with ResponseEntity
		userService.getAllUsersAsResponseEntity();

		//Delete user
		userService.deleteUser(userRick.getId());

		//Delete user: Invalid Id
		userService.deleteUser(134l);
	}
}
