package com.knf.dev.demo.kotlinspringthymeleafloginsignup

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinSpringThymeleafLoginSignupApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(KotlinSpringThymeleafLoginSignupApplication::class.java, *args)
        }
    }
}