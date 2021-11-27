package com.knf.dev.demo.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class OrderServiceApplication {
	private static final Logger LOG = LoggerFactory.
			  getLogger(OrderServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@RestController
	public class OrderController {

		@GetMapping(value = "/order")
		public String order() {
			LOG.info("Inside order service");
			return "Greetings from order";
		}
	}
}