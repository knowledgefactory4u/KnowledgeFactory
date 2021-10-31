package com.knf.dev.demo.kotlinspringsecurityjwt.response

class JwtResponse(
    var accessToken: String, var id: String,
    var employeename: String, var email: String, val roles: List<String>
) {
    var tokenType = "Bearer"

}