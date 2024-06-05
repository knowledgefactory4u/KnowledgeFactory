package com.knf.dev.demo.controller;

import com.knf.dev.demo.dto.ProfileDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/validation")
public class UserController {

    @PostMapping
    public String test(@Valid @RequestBody ProfileDto profileDto) {
        return "Done";
    }
}
