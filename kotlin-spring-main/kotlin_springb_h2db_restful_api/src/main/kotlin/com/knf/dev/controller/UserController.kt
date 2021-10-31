package com.knf.dev.controller

import com.knf.dev.entity.User
import com.knf.dev.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/")
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/users")
        fun getAllUsers(): List<User> =
        userRepository.findAll()

    @PostMapping("/users")
    fun createNewUser(@RequestBody user: User): User =
        userRepository.save(user)

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable(value = "id") userId: Long):
            ResponseEntity<User> {
        return userRepository.findById(userId).map { usr ->
            ResponseEntity.ok(usr)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/users/{id}")
    fun updateUserById(@PathVariable(value = "id") userId: Long,
                           @RequestBody newUser: User):
            ResponseEntity<User> {

        return userRepository.findById(userId).map { existingUser ->
            val updatedEmployee: User = existingUser
                .copy(firstName = newUser.firstName, lastName =
                newUser.lastName, emailId = newUser.emailId)
            ResponseEntity.ok().body(userRepository.save(updatedEmployee))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/users/{id}")
    fun deleteUserById(@PathVariable(value = "id") userId: Long):
            ResponseEntity<Void> {
        return userRepository.findById(userId).map { usr ->
            userRepository.delete(usr)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }
}