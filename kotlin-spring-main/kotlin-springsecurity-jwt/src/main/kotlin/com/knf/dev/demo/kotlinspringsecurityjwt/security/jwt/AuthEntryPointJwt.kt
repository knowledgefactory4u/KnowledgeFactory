package com.knf.dev.demo.kotlinspringsecurityjwt.security.jwt

import org.springframework.security.web.AuthenticationEntryPoint
import kotlin.Throws
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.knf.dev.demo.kotlinspringsecurityjwt.security.jwt.AuthEntryPointJwt
import org.slf4j.LoggerFactory
import org.springframework.security.core.AuthenticationException
import org.springframework.stereotype.Component

@Component
class AuthEntryPointJwt : AuthenticationEntryPoint {
    @Throws(IOException::class, ServletException::class)
    override fun commence(
        request: HttpServletRequest, response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        logger.error("Unauthorized error: {}", authException.message)
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(AuthEntryPointJwt::class.java)
    }
}