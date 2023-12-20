package com.knf.dev.demo.controller;

import com.knf.dev.demo.entity.User;
import com.knf.dev.demo.exception.ResourceNotFoundException;
import com.knf.dev.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Fetch all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    // create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Not found User with id = " + id));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
             @RequestBody User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Not found User with id = " + id));

        user.setEmail(userDetails.getEmail());
        user.setName(userDetails.getName());
        user.setAge(userDetails.getAge());

        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);

    }

    // delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser
               (@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Not found User with id = " + id));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}