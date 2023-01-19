package com.knf.dev.demo.controller;

import com.knf.dev.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    @GetMapping("/user")
    public String getuser () {
        return "user";
    }

    @ModelAttribute("user")
    public User user() {
        return new User("Sibin", "Alpha", "sibin@gmail.com");
    }
}
