package com.knowledgefactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KnowledgefactoryScheduler {

	public static void main(String[] args) {
		SpringApplication.run(KnowledgefactoryScheduler.class, args);
	}
}
