package com.knf.dev.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretTestController {

	@Value("${my-password}")
	private String myPassword;

	@GetMapping("/secret")
	public Map<String, String> secret() {

		Map<String, String> map = new HashMap<String, String>();
		map.put("myPassword", myPassword);
		return map;
	}
}
