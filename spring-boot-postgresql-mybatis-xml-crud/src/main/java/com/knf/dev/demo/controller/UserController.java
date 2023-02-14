package com.knf.dev.demo.controller;

import com.knf.dev.demo.exception.ResourceNotFoundException;
import com.knf.dev.demo.model.User;
import com.knf.dev.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Map<String, Boolean> createUser(@RequestBody User user)  {

        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = userRepository.insert(user) > 0 ?
                response.put("created", Boolean.TRUE) :
                response.put("created", Boolean.FALSE);

        return response;

    }

    // get user by id rest api
    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable Integer id) {

        User user = userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException
                ("User not exist with id :" + id));
        return user;
    }

   // update user rest api
   @PutMapping("/users/{id}")
   public Map<String, Boolean> updateUser(@PathVariable Integer id,
                                          @RequestBody User userDetails) {

      User user = userRepository.findById(id)
              .orElseThrow(() -> new ResourceNotFoundException
               ("User not exist with id :" + id));
       userDetails.setId(id);
       Map<String, Boolean> response = new HashMap<>();

       Boolean bool = userRepository.update(userDetails) > 0 ?
               response.put("updated", Boolean.TRUE) :
               response.put("updated", Boolean.FALSE);

      return response;
    }

    // delete user rest api
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser
               (@PathVariable Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("User not exist with id :" + id));

        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = userRepository.deleteById(user.getId()) > 0 ?
                response.put("deleted", Boolean.TRUE) :
                response.put("deleted", Boolean.FALSE);
        return response;
    }
}
