package com.knf.dev.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knf.dev.demo.model.User;
import com.knf.dev.demo.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") String id) {

		return userRepository.findById(id).map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElse(ResponseEntity.notFound().build());

	}

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {

		return userRepository.save(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") String id, @RequestBody User userDto) {

		Optional<User> userData = userRepository.findById(id);
		if (userData.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		User user = userData.get();
		user.setEmailId(userDto.getEmailId());
		user.setLastName(userDto.getLastName());
		user.setFirstName(userDto.getFirstName());
		user.setId(id);
		final User updateUser = userRepository.save(user);
		return ResponseEntity.ok(updateUser);
	}

	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") String id) {

		Optional<User> user = userRepository.findById(id);
		Map<String, Boolean> response = new HashMap<>();
		if (user.isEmpty()) {
			response.put("User Not Found", Boolean.FALSE);
		} else {
			userRepository.delete(user.get());
			response.put("deleted", Boolean.TRUE);
		}
		return response;
	}
}
