package com.knf.dev.demo.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {  
    @GetMapping("/hello")
    public String hello(Model model,
                        @RequestParam(value="message",
                                required=false,
                                  defaultValue="World") String message) {
        model.addAttribute("message", "Hello "+message);
        return "index";
    }
}