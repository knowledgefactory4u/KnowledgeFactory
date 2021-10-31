package com.knf.dev.demo.kotlinspringsecurityjwt.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class SignupRequest {
    var employeename: @NotBlank @Size(min = 3, max = 20) String? = null
    var email: @NotBlank @Size(max = 50) @Email String? = null
    var roles: Set<String>? = null
        private set
    var password: @NotBlank @Size(min = 6, max = 40) String? = null
    fun setRole(roles: Set<String>?) {
        this.roles = roles
    }
}