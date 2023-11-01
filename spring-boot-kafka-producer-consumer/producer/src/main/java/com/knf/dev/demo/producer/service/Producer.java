package com.knf.dev.demo.producer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    KafkaTemplate<String,String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topic;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageToTopic(String message)
    {
        kafkaTemplate.send(topic,message);
    }
}