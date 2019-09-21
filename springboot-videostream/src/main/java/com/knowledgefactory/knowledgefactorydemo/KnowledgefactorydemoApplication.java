package com.knowledgefactory.knowledgefactorydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({ "com" })

public class KnowledgefactorydemoApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(KnowledgefactorydemoApplication.class, args);
	}

	

}
