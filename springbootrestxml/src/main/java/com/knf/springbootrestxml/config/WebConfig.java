package com.knf.springbootrestxml.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
    configurer.defaultContentType(MediaType.APPLICATION_XML);
  }
}
