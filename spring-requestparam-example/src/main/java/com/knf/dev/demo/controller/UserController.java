package com.knf.dev.demo.controller;

import com.knf.dev.demo.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    @GetMapping(value = "/users")
    public User getUserByCountryAndName(
         @RequestParam(value = "name") String name,
         @RequestParam String country) {

        return new User(name,country);

    }
}
