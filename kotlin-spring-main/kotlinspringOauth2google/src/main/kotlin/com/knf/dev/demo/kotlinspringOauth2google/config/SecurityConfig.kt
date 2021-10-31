package com.knf.dev.demo.kotlinspringOauth2google.config

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import kotlin.Throws
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import java.lang.Exception

@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    public override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity.csrf().disable().antMatcher("/**").authorizeRequests()
            .antMatchers("/", "/index").authenticated()
            .anyRequest().authenticated()
            .and()
            .oauth2Login().permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutSuccessUrl("/")
    }
}