package com.knf.dev.demo.producer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    public static final String EXCHANGE_NAME = "myTopicExchange";
    public static final String ROUTING_KEY = "myRoutingKey.#";


    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMessage(String message){

        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
    }
}