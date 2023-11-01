package com.knf.dev.demo.producer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    JmsTemplate jmsTemplate;

    @Value("${activemq.topic.name}")
    private String topic;

    public Producer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessageToTopic(String message)
    {
        jmsTemplate.convertAndSend(topic,message);
    }
}