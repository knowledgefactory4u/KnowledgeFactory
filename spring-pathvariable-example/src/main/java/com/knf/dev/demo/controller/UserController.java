package com.knf.dev.demo.controller;

import com.knf.dev.demo.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    @GetMapping(value = "/users/{country}/{name}")
    public User getUserByCountryAndName
            (@PathVariable String country,
             @PathVariable(name = "name") String name) {

        return new User(name,country);

    }
}
