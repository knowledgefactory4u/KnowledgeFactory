package com.knf.dev.demo.controller;

import com.knf.dev.demo.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/validation")
public class UserController {

    @PostMapping
    public String test(@Valid @RequestBody UserDto userDto) {
        return "Done";
    }
}
