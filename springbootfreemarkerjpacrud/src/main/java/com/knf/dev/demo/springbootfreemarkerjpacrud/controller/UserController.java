package com.knf.dev.demo.springbootfreemarkerjpacrud.controller;

import com.knf.dev.demo.springbootfreemarkerjpacrud.exception.RecordNotFoundException;
import com.knf.dev.demo.springbootfreemarkerjpacrud.model.User;
import com.knf.dev.demo.springbootfreemarkerjpacrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String getAllUserView(Model model) {
        List<User> users = userService.getAllusers();
        model.addAttribute("users", users);
        return "home";
    }
    @GetMapping("/create")
    public String createUserView(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("isUpdate", false);
        return "create-update";
    }
    @PostMapping("/update/{id}")
    public String createUser(@ModelAttribute("user") User user,
                             @PathVariable("id") Long id) {
        user.setId(id);
        userService.createOrUpdateUser(user);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String updateUser(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("isUpdate", true);
        return "create-update";
    }
    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
