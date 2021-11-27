package com.knf.dev.demo.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CartServiceApplication {
	private static final Logger LOG = LoggerFactory.
			getLogger(CartServiceApplication.class);

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}

	@RestController
	public class CartController {
		@Autowired
		RestTemplate restTemplate;

		@GetMapping(value = "/cart")
		public String cart() {
			LOG.info("Inside cart service");
			String responseFromOrderService = restTemplate.
					getForObject("http://localhost:9093/order", 
							String.class);
			LOG.info("Successfully communicated " +
					"with order service");
			return "Greetings from cart" + ">>" +
					responseFromOrderService;
		}
	}
}