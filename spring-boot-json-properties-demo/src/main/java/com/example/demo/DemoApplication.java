package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

    @Value("${testdata1}")
    private String testData1;

    @Value("#{${valuesMap}}")
    private Map<String, Integer> valuesMap;

    @GetMapping
    public String echo() {

        System.out.println("Iterating the map....");
        for (Map.Entry<String, Integer> entry : valuesMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() 
                        + ", Value = " + entry.getValue());
        }
        return testData1;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}