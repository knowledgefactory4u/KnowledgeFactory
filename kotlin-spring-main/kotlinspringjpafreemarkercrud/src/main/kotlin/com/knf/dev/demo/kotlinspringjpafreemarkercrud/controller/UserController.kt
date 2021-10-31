package com.knf.dev.demo.kotlinspringjpafreemarkercrud.controller

import com.knf.dev.demo.kotlinspringjpafreemarkercrud.model.User
import org.springframework.beans.factory.annotation.Autowired
import com.knf.dev.demo.kotlinspringjpafreemarkercrud.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import kotlin.Throws
import javax.persistence.EntityNotFoundException

@Controller
class UserController {
    @Autowired
    private val userService: UserService? = null
    @GetMapping("/")
    fun getAllUserView(model: Model): String {
        val users = userService!!.allusers
        model.addAttribute("users", users)
        return "home"
    }

    @GetMapping("/create")
    fun createUserView(model: Model): String {
        val user = User()
        model.addAttribute("user", user)
        model.addAttribute("isUpdate", false)
        return "create-update"
    }

    @PostMapping("/update/{id}")
    fun createUser(
        @ModelAttribute("user") user: User,
        @PathVariable("id") id: Long?
    ): String {
        user.id = id
        userService!!.createOrUpdateUser(user)
        return "redirect:/"
    }

    @GetMapping("/update/{id}")
    @Throws(EntityNotFoundException::class)
    fun updateUser(
        model: Model,
        @PathVariable("id") id: Long?
    ): String {
        val user = userService!!.getUserById(id!!)
        model.addAttribute("user", user)
        model.addAttribute("isUpdate", true)
        return "create-update"
    }

    @PostMapping("/create")
    fun createUser(@ModelAttribute("user") user: User?): String {
        userService!!.createOrUpdateUser(user!!)
        return "redirect:/"
    }

    @GetMapping("/delete/{id}")
    @Throws(EntityNotFoundException::class)
    fun deleteUser(@PathVariable("id") id: Long?): String {
        userService!!.deleteUserById(id!!)
        return "redirect:/"
    }
}