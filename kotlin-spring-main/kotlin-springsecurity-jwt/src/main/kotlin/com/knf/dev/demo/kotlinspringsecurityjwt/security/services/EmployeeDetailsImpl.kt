package com.knf.dev.demo.kotlinspringsecurityjwt.security.services

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import com.knf.dev.demo.kotlinspringsecurityjwt.model.Employee
import com.knf.dev.demo.kotlinspringsecurityjwt.model.Role
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.stream.Collectors

class EmployeeDetailsImpl(
    val id: String?, private val username: String, val email: String?,
    @field:JsonIgnore private val password: String,
    private val authorities: Collection<GrantedAuthority>
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authorities
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val user = o as EmployeeDetailsImpl
        return id == user.id
    }

    companion object {
        private const val serialVersionUID = 1L
        fun build(user: Employee): EmployeeDetailsImpl {
            val authorities = user.roles.stream()
                .map { role: Role ->
                    SimpleGrantedAuthority(
                        role.name!!.name
                    )
                }.collect(Collectors.toList())
            return EmployeeDetailsImpl(
                user.id, user.employeename!!,
                user.email, user.password!!,
                authorities
            )
        }
    }
}