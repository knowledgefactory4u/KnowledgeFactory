package com.knf.dev.demo.springbootpagination.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.knf.dev.demo.springbootpagination.exception.ResourceNotFoundException;
import com.knf.dev.demo.springbootpagination.exception.ServerError;
import com.knf.dev.demo.springbootpagination.model.User;
import com.knf.dev.demo.springbootpagination.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	UserRepository userRepsoitory;

	@GetMapping("/users")
	public Map<String, Object> getAllUsers(
			@RequestParam(value = "country", required = false) String country,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "4") int size) {
		try {

			List<User> users = new ArrayList<User>();
			Pageable pagination = PageRequest.of(page, size);
			Page<User> userPage;
			if (country == null) {
				userPage = userRepsoitory.findAll(pagination);
			} else {
				userPage = userRepsoitory.findByCountryContaining(country, pagination);
			}
			users = userPage.getContent();
			Map<String, Object> response = new HashMap<String, Object>();
			response.put("users", users);
			response.put("totalPages", userPage.getTotalPages());
			return response;
		} catch (Exception e) {
			throw new ServerError(e.getMessage());
		}

	}

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {

		return userRepsoitory.save(user);
	}

	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {

		User userDetails = userRepsoitory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		userDetails.setCountry(user.getCountry());
		userDetails.setEmail(user.getEmail());
		userDetails.setName(user.getName());

		return userRepsoitory.save(userDetails);
	}

	@DeleteMapping("users/{id}")
	public Boolean deleteUser(@PathVariable("id") Long id) {
		User user = userRepsoitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		userRepsoitory.delete(user);
		return true;
	}

	@GetMapping("users/{id}")
	public User findById(@PathVariable("id") Long id) {
		User user = userRepsoitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		return user;
	}
}
