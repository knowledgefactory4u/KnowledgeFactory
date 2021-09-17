package com.knf.dev.demo.springbootmybatiscrudexample.controller;

import com.knf.dev.demo.springbootmybatiscrudexample.exception.UserIdAlreadyExistException;
import com.knf.dev.demo.springbootmybatiscrudexample.exception.UserIdNotFoundException;
import com.knf.dev.demo.springbootmybatiscrudexample.model.User;
import com.knf.dev.demo.springbootmybatiscrudexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

// get all users
    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

// create user rest API
    @PostMapping("/users")
    public User createUser(@RequestBody User user)  {
        if(userRepository.findById(user.getId())==null) {
            int id = userRepository.insert(user);
            return userRepository.findById(user.getId());
        }else
        {
            throw new UserIdAlreadyExistException();
        }

    }

// get user by id rest api
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id);
        if(user==null)
        {
            throw new UserIdNotFoundException();
        }
        return ResponseEntity.ok(user);
    }

// update user rest api
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
             @RequestBody User userDetails) {
            if(userRepository.update(new User(id, userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmailId()))==0)
            {
                throw new UserIdNotFoundException();
            }

       return ResponseEntity.ok(userRepository.findById(id));
    }

// delete user rest api
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser
               (@PathVariable Long id) {
        userRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}