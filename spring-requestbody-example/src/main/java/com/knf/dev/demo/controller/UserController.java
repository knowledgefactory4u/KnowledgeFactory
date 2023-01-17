package com.knf.dev.demo.controller;

import com.knf.dev.demo.dto.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    /* @RequestBody maps web request's
         body to method parameter User Object*/
    @PostMapping(path = "/users")
    public User saveUser(@RequestBody User user) {

        String name = user.getName();
        String email = user.getEmail();
        System.out.println("Name: "+ name);
        System.out.println("Email: "+ email);
        //userRepository.saveUser(user);
        return user;
    }
    @PostMapping(path = "/login")
    public Boolean validateLogin
            (@RequestBody Map<String, String> login) {

        if (login == null) return false;
        String username = login.get("username");
        String password = login.get("password");

        // simple check
        if ("knowledgefactory".equalsIgnoreCase(username)
                && "knf123#".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}
