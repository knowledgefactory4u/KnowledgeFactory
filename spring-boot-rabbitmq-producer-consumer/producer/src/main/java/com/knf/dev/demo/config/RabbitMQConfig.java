package com.knf.dev.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${knf.queue.name}")
    private String queue;

    @Value("${knf.exchange.name}")
    private String exchange;

    @Value("${knf.routing.key}")
    private String routingKey;

    // Bean for rabbitmq queue
    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    // Bean for rabbitmq exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    // Binding between queue and exchange using routing key
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }
}