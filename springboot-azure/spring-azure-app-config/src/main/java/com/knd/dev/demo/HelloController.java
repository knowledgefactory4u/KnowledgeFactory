package com.knd.dev.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${config.greeting}")
	private String greeting;

	@GetMapping
	public Map<String, String> getMessage() {

		Map<String, String> message =
            new HashMap<String, String>();
		message.put("message", greeting);
		return message;
	}
}
