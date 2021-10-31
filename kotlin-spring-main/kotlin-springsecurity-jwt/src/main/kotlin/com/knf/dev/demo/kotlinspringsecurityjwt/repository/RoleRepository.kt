package com.knf.dev.demo.kotlinspringsecurityjwt.repository

import org.springframework.data.mongodb.repository.MongoRepository
import com.knf.dev.demo.kotlinspringsecurityjwt.model.ERole
import com.knf.dev.demo.kotlinspringsecurityjwt.model.Role
import java.util.*

interface RoleRepository : MongoRepository<Role?, String?> {
    fun findByName(name: ERole?): Optional<Role?>?
}