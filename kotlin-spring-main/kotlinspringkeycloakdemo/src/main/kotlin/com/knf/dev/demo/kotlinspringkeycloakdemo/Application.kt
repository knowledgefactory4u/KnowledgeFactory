package com.knf.dev.demo.kotlinspringkeycloakdemo

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {
	@Bean
	fun keycloakSpringBootConfigResolver(): KeycloakSpringBootConfigResolver {
		return KeycloakSpringBootConfigResolver()
	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(Application::class.java, *args)
		}
	}
}