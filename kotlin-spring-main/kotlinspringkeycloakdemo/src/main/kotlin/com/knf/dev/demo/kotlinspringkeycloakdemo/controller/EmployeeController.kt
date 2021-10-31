package com.knf.dev.demo.kotlinspringkeycloakdemo.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import com.knf.dev.demo.kotlinspringkeycloakdemo.service.KeycloakService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.knf.dev.demo.kotlinspringkeycloakdemo.Vo.EmployeeVO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

@RequestMapping(value = ["/employees"])
@RestController
class EmployeeController {
    @Autowired
    private val keycloakService: KeycloakService? = null
    @PostMapping(path = ["/create"])
    fun createEmployee(@RequestBody employeeVo: EmployeeVO?): ResponseEntity<*> {
        return ResponseEntity.ok(keycloakService!!.createEmployee(employeeVo!!))
    }

    @PostMapping(path = ["/login"])
    fun login(@RequestBody employeeVo: EmployeeVO?): ResponseEntity<*> {
        return ResponseEntity.ok(keycloakService!!.login(employeeVo!!))
    }

    @get:GetMapping(value = ["/unprotected"])
    val unProtectedData: String
        get() = "This api is not protected."

    @get:GetMapping(value = ["/protected"])
    val protectedData: String
        get() = "This api is protected."
}