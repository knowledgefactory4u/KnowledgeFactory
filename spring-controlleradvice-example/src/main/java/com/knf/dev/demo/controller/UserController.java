package com.knf.dev.demo.controller;

import com.knf.dev.demo.entity.User;
import com.knf.dev.demo.exception.UserNotFoundException;
import com.knf.dev.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    // create user rest API
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // get user by id rest api
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException
                        ("User does not exist with id :" + id));
        return ResponseEntity.ok(user);
    }
}
