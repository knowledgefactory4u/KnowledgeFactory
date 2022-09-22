package com.knf.dev.demo.springdatajdbcazurepostgrescrud.controller;

import com.knf.dev.demo.springdatajdbcazurepostgrescrud.exception.UserNotFound;
import com.knf.dev.demo.springdatajdbcazurepostgrescrud.model.User;
import com.knf.dev.demo.springdatajdbcazurepostgrescrud.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    // Create user
    @PostMapping
    public ResponseEntity<User> createUser
          (@RequestBody User user) {

        User newuser = new User(user.getFirstName(),
                user.getLastName(), user.getEmail());
        userRepository.save(newuser);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);

    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser
    (@PathVariable("id") Long id, @RequestBody User user) {

        Optional<User> userdata = userRepository.findById(id);
        if (userdata.isPresent()) {
            User _user = userdata.get();
            _user.setEmail(user.getEmail());
            _user.setFirstName(user.getFirstName());
            _user.setLastName(user.getLastName());
            return new ResponseEntity<>(userRepository
                    .save(_user), HttpStatus.OK);
        } else {
            throw new UserNotFound("Invalid User Id");
        }
    }

    // Get all Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID
    (@PathVariable("id") Long id) {

        Optional<User> userdata = userRepository.findById(id);
        if (userdata.isPresent()) {
            return new ResponseEntity<>(userdata.get(), HttpStatus.OK);
        } else {
            throw new UserNotFound("Invalid User Id");
        }

    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser
    (@PathVariable("id") Long id) {

        Optional<User> userdata = userRepository.findById(id);
        if (userdata.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new UserNotFound("Invalid User Id");
        }
    }
}
