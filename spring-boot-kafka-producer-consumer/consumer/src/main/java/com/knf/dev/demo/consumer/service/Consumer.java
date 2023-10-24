package com.knf.dev.demo.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = {"${kafka.topic.name}"}, groupId = "${kafka.topic.name}")
    public void listenToTopic(String message)
    {
        System.out.println("Message arrived! Message: " + message);
    }
}
