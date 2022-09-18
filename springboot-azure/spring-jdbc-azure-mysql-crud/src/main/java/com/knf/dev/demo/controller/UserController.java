package com.knf.dev.demo.controller;

import com.knf.dev.demo.model.User;
import com.knf.dev.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    //Create user
    @PostMapping
    public ResponseEntity<String> save(@RequestBody User usr) {

            var userId = userRepository.saveAndReturnId(usr);

            return new ResponseEntity<String>
             ("User successfully created , Id =" 
                + userId, HttpStatus.CREATED);

    }

    //Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAll() {

            return new ResponseEntity<List<User>>
              (userRepository.findAll(), HttpStatus.OK);

    }

    //Get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getById
        (@PathVariable("id") Long id) {

        return new ResponseEntity<>
           (userRepository.findOne(id), HttpStatus.OK);

    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser
         (@PathVariable("id") Long id) {

        userRepository.delete(userRepository.findOne(id).id());

        return new ResponseEntity<>
           ("User removed successfully", HttpStatus.OK);

    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser
       (@PathVariable("id") Long id, @RequestBody User user) {

        var _user = userRepository.findOne(id);
        var _upUSer = new User(_user.id(),
                user.firstName(),user.lastName(),user.email());
        
        userRepository.update(_upUSer);
        return new ResponseEntity<>
           ("Updated successfully", HttpStatus.OK);

    }
}
