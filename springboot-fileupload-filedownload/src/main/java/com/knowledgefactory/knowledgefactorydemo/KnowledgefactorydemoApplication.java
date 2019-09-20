package com.knowledgefactory.knowledgefactorydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({ "com" })

public class KnowledgefactorydemoApplication {
	// private static final Logger log =
	// LoggerFactory.getLogger(KnowledgefactorydemoApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(KnowledgefactorydemoApplication.class, args);
	}

	

}
