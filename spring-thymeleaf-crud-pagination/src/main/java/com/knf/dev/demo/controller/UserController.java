package com.knf.dev.demo.controller;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.knf.dev.demo.domain.User;
import com.knf.dev.demo.exception.RecordNotFoundException;
import com.knf.dev.demo.service.UserService;
import com.knf.dev.demo.util.Pager;

@Controller
public class UserController {

	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 3;
	private static final int[] PAGE_SIZES = { 3, 6, 9, 12 };

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/")
	public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {

		var modelAndView = new ModelAndView("list-users");

		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);

		int evalPage = page.filter(p -> p >= 1).map(p -> p - 1).orElse(INITIAL_PAGE);

		var users = service.findAllPageable(PageRequest.of(evalPage, evalPageSize));
		var pager = new Pager(users.getTotalPages(), users.getNumber(), BUTTONS_TO_SHOW);

		modelAndView.addObject("users", users);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;
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
