package com.knf.dev.demo.kotlinspringsecurityjwt.request

import javax.validation.constraints.NotBlank

class LoginRequest {
    var employeename: @NotBlank String? = null
    var password: @NotBlank String? = null
}