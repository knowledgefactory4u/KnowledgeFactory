package com.knf.dev.controller

import com.knf.dev.entity.User
import com.knf.dev.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.ui.Model

import org.springframework.web.bind.annotation.GetMapping
import java.util.*
import org.springframework.web.bind.annotation.PathVariable


@Controller
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/")
    fun getAllUsers(model: Model): String? {
        val list: List<User> = userRepository.findAll()
        model.addAttribute("users", list)
        return "list-users"
    }

    @PostMapping(path = ["/createUser"])
    fun createNewUser(@ModelAttribute user: User): String {
        userRepository.save(user)
        return "redirect:/";
    }

    @GetMapping(path = ["/add"])
    fun addUserById(): String? {
        return "add-user"
    }

    @GetMapping(path = ["/edit/{id}"])
    fun editUserById(model: Model, @PathVariable("id") id: Long): String? {
        model.addAttribute("user", userRepository.findById(id))
        return "edit-user"
    }

    @PostMapping(path = ["/editUser"])
    fun editUser(@ModelAttribute user: User): String? {
        userRepository.save(user)
        return "redirect:/"
    }

    @GetMapping(path = ["/delete/{id}"])
    fun deleteUserById(@PathVariable("id") id: Long): String? {
        userRepository.deleteById(id)
        return "redirect:/"
    }

}