package com.knowledgefactory.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.knowledgefactory.entity.User;
import com.knowledgefactory.exception.RecordNotFoundException;
import com.knowledgefactory.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@GetMapping({ "/" })
	public String getAllUsers(Model model) {

		List<User> list = service.getAllusers();
		model.addAttribute("users", list);
		return "list-users";
	}

	@GetMapping(path = { "/addOrEdit", "/addOrEdit/{id}" })
	public String editUserById(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {

		if (id.isPresent()) {
			User entity = service.getUserById(id.get());
			model.addAttribute("user", entity);
		} else {
			model.addAttribute("user", new User());
		}
		return "add-edit-user";
	}

	@GetMapping(path = "/delete/{id}")
	public String deleteUserById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {

		service.deleteUserById(id);
		return "redirect:/";
	}

	@PostMapping(path = "/createOrUpdateUser")
	public String createOrUpdateUser(User user) {

		service.createOrUpdateUser(user);
		return "redirect:/";
	}
}