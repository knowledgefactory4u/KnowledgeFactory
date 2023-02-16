package com.knf.dev.demo.controller;

import com.knf.dev.demo.model.Card;
import com.knf.dev.demo.model.User;
import com.knf.dev.demo.repository.CardRepository;
import com.knf.dev.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CardRepository cardRepository;

    @GetMapping("users/{email}")
    public User getUserById(@PathVariable String email)
     {
      return userRepository.selectUserById(email);
     }

    @GetMapping("cards/{id}")
    public Card getCardById(@PathVariable Integer id)
    {
        return cardRepository.selectCardById(id);
    }
}
