package com.knf.dev.demo.kotlinspringthymeleafloginsignup.repository

import com.knf.dev.demo.kotlinspringthymeleafloginsignup.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User?, Long?> {
    fun findByEmail(email: String?): User?
}