package com.knf.dev.demo.kotlinspringsecurityjwt.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import com.knf.dev.demo.kotlinspringsecurityjwt.repository.EmployeeRepository
import com.knf.dev.demo.kotlinspringsecurityjwt.repository.RoleRepository
import org.springframework.security.crypto.password.PasswordEncoder
import com.knf.dev.demo.kotlinspringsecurityjwt.security.jwt.JwtUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import com.knf.dev.demo.kotlinspringsecurityjwt.request.LoginRequest
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import com.knf.dev.demo.kotlinspringsecurityjwt.security.services.EmployeeDetailsImpl
import org.springframework.security.core.GrantedAuthority
import java.util.stream.Collectors
import com.knf.dev.demo.kotlinspringsecurityjwt.response.JwtResponse
import com.knf.dev.demo.kotlinspringsecurityjwt.request.SignupRequest
import com.knf.dev.demo.kotlinspringsecurityjwt.response.MessageResponse
import com.knf.dev.demo.kotlinspringsecurityjwt.model.Employee
import java.util.HashSet
import com.knf.dev.demo.kotlinspringsecurityjwt.model.ERole
import com.knf.dev.demo.kotlinspringsecurityjwt.model.Role
import java.lang.RuntimeException
import java.util.function.Consumer
import java.util.function.Supplier

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
class AuthController {
    @Autowired
    var authenticationManager: AuthenticationManager? = null

    @Autowired
    var employeeRepository: EmployeeRepository? = null

    @Autowired
    var roleRepository: RoleRepository? = null

    @Autowired
    var encoder: PasswordEncoder? = null

    @Autowired
    var jwtUtils: JwtUtils? = null
    @PostMapping("/signin")
    fun authenticateEmployee(@RequestBody loginRequest: @Valid LoginRequest?):
            ResponseEntity<*> {
        val authentication = authenticationManager!!.authenticate(
            UsernamePasswordAuthenticationToken
                (loginRequest!!.employeename, loginRequest.password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        val jwt = jwtUtils!!.generateJwtToken(authentication)
        val employeeDetails = authentication.principal as EmployeeDetailsImpl
        val roles = employeeDetails.authorities.stream().
        map { item: GrantedAuthority -> item.authority }
            .collect(Collectors.toList())
        return ResponseEntity.ok(
            JwtResponse(
                jwt, employeeDetails.id!!,
                employeeDetails.username,
                employeeDetails.email!!, roles
            )
        )
    }

    @PostMapping("/signup")
    fun registerUser(@RequestBody signUpRequest:
                     @Valid SignupRequest?): ResponseEntity<*> {
        if (employeeRepository!!.
            existsByEmployeename(signUpRequest!!.employeename)!!) {
            return ResponseEntity.badRequest().
            body(MessageResponse("Error: Employeename is already taken!"))
        }
        if (employeeRepository!!.
            existsByEmail(signUpRequest.email)!!) {
            return ResponseEntity.badRequest().
            body(MessageResponse
                ("Error: Email is already in use!"))
        }

        // Create new employee account
        val employee = Employee(
            signUpRequest.employeename,
            signUpRequest.email,
            encoder!!.encode(signUpRequest.password)
        )
        val strRoles = signUpRequest.roles
        val roles: MutableSet<Role> = HashSet()
        if (strRoles == null) {
            val employeeRole = roleRepository!!.findByName(ERole.ROLE_EMPLOYEE)
                ?.orElseThrow(Supplier
                { RuntimeException("Error: Role is not found.") })!!
            roles.add(employeeRole)
        } else {
            strRoles.forEach(Consumer { role: String? ->
                when (role) {
                    "admin" -> {
                        val adminRole = roleRepository!!.
                        findByName(ERole.ROLE_ADMIN)
                            ?.orElseThrow(Supplier
                            { RuntimeException("Error: Role is not found.") })!!
                        roles.add(adminRole)
                    }
                    else -> {
                        val defaultRole = roleRepository!!.
                        findByName(ERole.ROLE_EMPLOYEE)
                            ?.orElseThrow(Supplier
                            { RuntimeException("Error: Role is not found.") })!!
                        roles.add(defaultRole)
                    }
                }
            })
        }
        employee.roles = roles
        employeeRepository!!.save(employee)
        return ResponseEntity.
        ok(MessageResponse("Employee registered successfully!"))
    }
}