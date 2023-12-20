package com.knf.dev.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${user.base.url}")
    String baseUrl;

    @Bean
    RestClient restClient() {
        return RestClient.create(baseUrl);
    }
}
