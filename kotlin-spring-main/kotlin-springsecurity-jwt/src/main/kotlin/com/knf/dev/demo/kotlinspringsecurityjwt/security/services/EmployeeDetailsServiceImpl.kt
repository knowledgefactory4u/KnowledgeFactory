package com.knf.dev.demo.kotlinspringsecurityjwt.security.services

import com.knf.dev.demo.kotlinspringsecurityjwt.model.Employee
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import kotlin.Throws
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import com.knf.dev.demo.kotlinspringsecurityjwt.repository.EmployeeRepository

@Service
class EmployeeDetailsServiceImpl : UserDetailsService {
    @Autowired
    var employeeRepository: EmployeeRepository? = null
    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(employeename: String): UserDetails {
        val employee: Employee = employeeRepository!!.findByEmployeename(employeename)
            ?.orElseThrow { UsernameNotFoundException("Employee Not Found with username: " +
                    "$employeename") }!!
        return EmployeeDetailsImpl.build(employee)
    }
}