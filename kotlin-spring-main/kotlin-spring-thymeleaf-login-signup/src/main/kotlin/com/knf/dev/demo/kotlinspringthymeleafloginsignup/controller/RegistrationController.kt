package com.knf.dev.demo.kotlinspringthymeleafloginsignup.controller

import org.springframework.web.bind.annotation.RequestMapping
import com.knf.dev.demo.kotlinspringthymeleafloginsignup.service.UserService
import org.springframework.web.bind.annotation.ModelAttribute
import com.knf.dev.demo.kotlinspringthymeleafloginsignup.dto.UserRegistrationDto
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
@RequestMapping("/registration")
class RegistrationController(private val userService: UserService) {
    @ModelAttribute("user")
    fun userRegistrationDto(): UserRegistrationDto {
        return UserRegistrationDto()
    }

    @GetMapping
    fun showRegistrationForm(): String {
        return "registration"
    }

    @PostMapping
    fun registerUserAccount(@ModelAttribute("user") registrationDto: UserRegistrationDto?): String {
        userService.save(registrationDto)
        return "redirect:/registration?success"
    }
}