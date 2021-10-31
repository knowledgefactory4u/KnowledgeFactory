package com.knf.dev.demo.kotlinspringjpamustachecrud.repository

import com.knf.dev.demo.kotlinspringjpamustachecrud.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User?, Long?>