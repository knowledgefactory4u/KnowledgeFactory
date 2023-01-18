package com.knf.dev.demo.controller;

import com.knf.dev.demo.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    @GetMapping(value = "/users")
    public User getUser(@RequestHeader String token) {

        System.out.println("printing the token "+token);
        return new User("Sibin","India");

    }

    @GetMapping("/headers")
    public String handleRequestHeader (@RequestHeader Map<String, String> map) {

        System.out.println("printing the header"+map);
        return "Success";
    }
}
