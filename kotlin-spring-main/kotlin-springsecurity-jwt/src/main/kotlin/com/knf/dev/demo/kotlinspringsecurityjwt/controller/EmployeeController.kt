package com.knf.dev.demo.kotlinspringsecurityjwt.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import com.knf.dev.demo.kotlinspringsecurityjwt.response.MessageResponse
import org.springframework.security.access.prepost.PreAuthorize

@CrossOrigin(origins = ["*"], maxAge = 4800)
@RestController
@RequestMapping("/api/test")
class EmployeeController {
    @GetMapping("/all")
    fun allAccess(): MessageResponse {
        return MessageResponse("Public ")
    }

    @GetMapping("/employee")
    @PreAuthorize("hasRole('EMPLOYEE') ")
    fun employeeAccess(): MessageResponse {
        return MessageResponse("Employee zone")
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    fun adminAccess(): MessageResponse {
        return MessageResponse("Admin zone")
    }
}