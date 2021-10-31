package com.knf.dev.demo.kotlinspringsecurityjwt.security

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.beans.factory.annotation.Autowired
import com.knf.dev.demo.kotlinspringsecurityjwt.security.jwt.AuthEntryPointJwt
import com.knf.dev.demo.kotlinspringsecurityjwt.security.services.EmployeeDetailsServiceImpl
import kotlin.Throws
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import com.knf.dev.demo.kotlinspringsecurityjwt.security.jwt.AuthTokenFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.authentication.AuthenticationManager
import java.lang.Exception

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Autowired
    private val unauthorizedHandler: AuthEntryPointJwt? = null

    @Autowired
    var employeeDetailsService: EmployeeDetailsServiceImpl? = null
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.cors().and().csrf().disable().exceptionHandling().
        authenticationEntryPoint(unauthorizedHandler).and()
            .sessionManagement().
            sessionCreationPolicy(SessionCreationPolicy.STATELESS).
            and().authorizeRequests()
            .antMatchers("/api/auth/**").permitAll().
            antMatchers("/api/test/**").permitAll().anyRequest()
            .authenticated()
        http.addFilterBefore(
            authenticationJwtTokenFilter(),
            UsernamePasswordAuthenticationFilter::class.java
        )
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationJwtTokenFilter(): AuthTokenFilter {
        return AuthTokenFilter()
    }

    @Throws(Exception::class)
    public override fun configure
                (authenticationManagerBuilder: AuthenticationManagerBuilder) {
        authenticationManagerBuilder.userDetailsService(employeeDetailsService).
        passwordEncoder(passwordEncoder())
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}