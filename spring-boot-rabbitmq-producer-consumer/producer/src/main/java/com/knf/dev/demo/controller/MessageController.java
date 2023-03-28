package com.knf.dev.demo.controller;

import com.knf.dev.demo.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @GetMapping("/produce")
    public String sendMessage(@RequestParam("message") String message){

        rabbitMQProducer.sendMessage(message);
        return "Message was sent successfully";
    }
}