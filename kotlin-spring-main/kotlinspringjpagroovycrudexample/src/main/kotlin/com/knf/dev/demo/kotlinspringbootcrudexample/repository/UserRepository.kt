package com.knf.dev.demo.kotlinspringbootcrudexample.repository

import com.knf.dev.demo.kotlinspringbootcrudexample.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User?, Long?>