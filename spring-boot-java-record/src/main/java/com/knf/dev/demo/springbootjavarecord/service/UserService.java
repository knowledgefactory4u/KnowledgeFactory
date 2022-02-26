package com.knf.dev.demo.springbootjavarecord.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.knf.dev.demo.springbootjavarecord.dto.User;
import com.knf.dev.demo.springbootjavarecord.repsitory.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repsoitory ;

	//User mapper
	public User mapUser(com.knf.dev.demo.
	    springbootjavarecord.
			entity.User user) {
		User userDto = new User(user.getId(), 
				          user.getFirstName(), 
				              user.getLastName(), 
				                  user.getEmail());
		return userDto;
	}

	public List<User> getAllUsers() {
		
		//Fetch all users
		List<com.knf.dev.demo.
	    springbootjavarecord.
			entity.User> users = repsoitory.findAll();

		//converting list of user entity to
		// list of user record using java stream 
		return users.stream().
				map(this::mapUser).
				  collect(Collectors.toList());
	}

	public User getUserById(Long id) {

		// Fetch user by id
		Optional<com.knf.dev.demo.
		    springbootjavarecord.
		        entity.User> user 
		= repsoitory.findById(id);

		// converting user entity to
		// user record
		return mapUser(user.get());
	}
	
}
