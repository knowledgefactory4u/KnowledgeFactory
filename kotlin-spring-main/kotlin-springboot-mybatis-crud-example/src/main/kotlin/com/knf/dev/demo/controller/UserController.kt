package com.knf.dev.demo.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import com.knf.dev.demo.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.knf.dev.demo.exception.UserIdAlreadyExistException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity
import com.knf.dev.demo.exception.UserIdNotFoundException
import com.knf.dev.demo.model.User
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import java.util.HashMap

@RestController
@RequestMapping("/api/v1/")
class UserController {
    @Autowired
    private val userRepository: UserRepository? = null

    // get all users
    @get:GetMapping("/users")
    val allUsers: List<User?>?
        get() = userRepository!!.findAll()

    // create user rest API
    @PostMapping("/users")
    fun createUser(@RequestBody user: User): User? {
        return if (userRepository!!.findById(user.id) == null) {
            val id = userRepository.insert(user)
            userRepository.findById(user.id)
        } else {
            throw UserIdAlreadyExistException()
        }
    }

    // get user by id rest api
    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable id: Long?): ResponseEntity<User> {
        val user = userRepository!!.findById(id!!) ?: throw UserIdNotFoundException()
        return ResponseEntity.ok(user)
    }

    // update user rest api
    @PutMapping("/users/{id}")
    fun updateUser(
        @PathVariable id: Long?,
        @RequestBody userDetails: User
    ): ResponseEntity<User> {
        if (userRepository!!.update(
                User(
                    id!!, userDetails.firstName,
                    userDetails.lastName, userDetails.emailId
                )
            ) == 0
        ) {
            throw UserIdNotFoundException()
        }
        return ResponseEntity.ok(userRepository.findById(id))
    }

    // delete user rest api
    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Long?): ResponseEntity<Map<String, Boolean>> {
        userRepository!!.deleteById(id!!)
        val response: MutableMap<String, Boolean> = HashMap()
        response["deleted"] = java.lang.Boolean.TRUE
        return ResponseEntity.ok(response)
    }
}