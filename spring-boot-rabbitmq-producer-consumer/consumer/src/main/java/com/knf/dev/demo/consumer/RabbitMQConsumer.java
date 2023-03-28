package com.knf.dev.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {


    @RabbitListener(queues = {"${knf.queue.name}"})
    public void consume(String message){

        System.out.println("Message arrived! Message: " + message);
    }
}