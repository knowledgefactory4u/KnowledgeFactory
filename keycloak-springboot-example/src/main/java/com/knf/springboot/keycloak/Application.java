package com.knf.springboot.keycloak;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public KeycloakSpringBootConfigResolver keycloakSpringBootConfigResolver(){
        return new KeycloakSpringBootConfigResolver();
    }
}
