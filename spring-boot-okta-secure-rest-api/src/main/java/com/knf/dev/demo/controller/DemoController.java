package com.knf.dev.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/public")
    public String publicMsg(){

        return "Public...";
    }

    @GetMapping("/protected")
    public String protectedMsg(){

        return "Protected...";
    }
}
