package com.knf.dev.demo.controller;

import com.knf.dev.demo.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class UserController {

    // @ResponseBody at method return type level.
    @GetMapping(value = "/example1/users")
    public @ResponseBody List<User> getUsersABC() {

        User user1= new User();
        user1.setEmail("user1@gmail.com");
        user1.setName("John");

        User user2= new User();
        user2.setEmail("user2@gmail.com");
        user2.setName("Sibin");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        return list;
    }

    // @ResponseBody at method level
    @GetMapping(value = "/example2/users")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsersBCD() {
        User user1= new User();
        user1.setEmail("user1@gmail.com");
        user1.setName("John");

        User user2= new User();
        user2.setEmail("user2@gmail.com");
        user2.setName("Sibin");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        return list;
    }
}
