package com.knf.dev.demo.account;

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
public class AccountServiceApplication {
	private static final Logger LOG = LoggerFactory.
	   getLogger(AccountServiceApplication.class);

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@RestController
	public class AccountController {
		@Autowired
		RestTemplate restTemplate;

		@GetMapping(value = "/account")
		public String account() {
			LOG.info("Inside account service");
			String responseFromProductService = restTemplate.
			       getForObject("http://localhost:9090/product",
					String.class);
			LOG.info("Successfully communicated " +
			   "with product service");
			return responseFromProductService;
		}
	}
}
