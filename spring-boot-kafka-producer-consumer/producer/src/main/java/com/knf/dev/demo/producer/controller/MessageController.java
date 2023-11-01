package com.knf.dev.demo.producer.controller;

import com.knf.dev.demo.producer.service.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    Producer producer;

    public MessageController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/sendMessage")
    public String publishMessage(@RequestParam("message") String message) {

        producer.sendMessageToTopic(message);
        return "Message was sent successfully";
    }
}