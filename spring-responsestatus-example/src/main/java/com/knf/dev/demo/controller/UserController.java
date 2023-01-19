package com.knf.dev.demo.controller;

import com.knf.dev.demo.exception.UserNotFoundException;
import com.knf.dev.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(
            @PathVariable(value = "id") Integer userId)
            throws UserNotFoundException {

        Map< Integer, User > map = new HashMap< >();
        map.put(1, new User(1l, "Sibin"));
        map.put(2, new User(2l, "Jerry"));
        map.put(3, new User(3l, "Michael"));

        if (!map.containsKey(userId)) {
            throw new UserNotFoundException
                    ("User not found for " + userId);
        }
        return ResponseEntity.ok(map.get(userId));
    }
}
