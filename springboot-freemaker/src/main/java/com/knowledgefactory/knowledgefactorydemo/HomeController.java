package com.knowledgefactory.knowledgefactorydemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/", "/welcome"})
    public String hello(Model model) {
        model.addAttribute("name", "knowledgefactory4upeoples@gmail.net");
        return "index";
    }
}
