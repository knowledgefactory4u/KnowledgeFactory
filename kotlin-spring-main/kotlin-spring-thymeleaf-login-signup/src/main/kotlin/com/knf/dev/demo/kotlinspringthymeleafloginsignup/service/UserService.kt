package com.knf.dev.demo.kotlinspringthymeleafloginsignup.service

import org.springframework.security.core.userdetails.UserDetailsService
import com.knf.dev.demo.kotlinspringthymeleafloginsignup.dto.UserRegistrationDto
import com.knf.dev.demo.kotlinspringthymeleafloginsignup.model.User

interface UserService : UserDetailsService {
    fun save(registrationDto: UserRegistrationDto?): User?
    val all: List<User?>?
}