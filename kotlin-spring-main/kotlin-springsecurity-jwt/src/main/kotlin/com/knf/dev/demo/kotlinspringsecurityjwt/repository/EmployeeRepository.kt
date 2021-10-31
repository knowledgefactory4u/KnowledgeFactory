package com.knf.dev.demo.kotlinspringsecurityjwt.repository

import com.knf.dev.demo.kotlinspringsecurityjwt.model.Employee
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*


interface EmployeeRepository : MongoRepository<Employee?, String?> {
    fun findByEmployeename(employeename: String?): Optional<Employee?>?
    fun existsByEmployeename(employeename: String?): Boolean?
    fun existsByEmail(email: String?): Boolean?
}