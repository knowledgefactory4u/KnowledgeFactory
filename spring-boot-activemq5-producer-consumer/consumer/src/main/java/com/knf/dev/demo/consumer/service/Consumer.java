package com.knf.dev.demo.consumer.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @JmsListener(destination = "${activemq.topic.name}")
    public void listenToTopic(String message)
    {
        System.out.println("Message arrived! Message: " + message);
    }
}