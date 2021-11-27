package com.knf.dev.demo.product;

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
public class ProductServiceApplication {
	private static final Logger LOG = LoggerFactory.
			getLogger(ProductServiceApplication.class);

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@RestController
	public class ProductController {
		@Autowired
		RestTemplate restTemplate;

		@GetMapping(value = "/product")
		public String product() {
			LOG.info("Inside product service");
			String responseFromCartService = restTemplate.
					getForObject("http://localhost:9092/cart", 
							String.class);
			LOG.info("Successfully communicated " + 
							"with cart service");
			return "Greetings from product" + ">>" + 
							responseFromCartService;
		}
	}
}