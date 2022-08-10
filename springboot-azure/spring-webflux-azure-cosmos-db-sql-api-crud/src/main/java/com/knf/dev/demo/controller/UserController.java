package com.knf.dev.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping
	Flux<User> getAll() {

		return repository.findAll();
	}

	@GetMapping("/{id}")
	Mono<User> getUser(@PathVariable("id") String id) {

		return repository.findById(id);
	}

	@PostMapping
	Mono<User> addUser(@RequestBody User user) {

		return repository.save(user);
	}

	@PutMapping("/{id}")
	private Mono<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {

		return repository.findById(id).flatMap(user1 -> {
			user.setId(id);
			return repository.save(user);
		}).switchIfEmpty(Mono.empty());
	}

	@DeleteMapping("/{id}")
	Mono<Void> deleteById(@PathVariable("id") String id) {

		return repository.findById(id).flatMap(p -> repository.deleteById(p.getId()));
	}
}
