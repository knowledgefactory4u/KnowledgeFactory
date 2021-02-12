package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CustomerNotFoundException;

@RestController
public class DemoController {

	@GetMapping(path = "/customer/{id}")
	public @ResponseBody ResponseEntity<String> getCustomerId(@PathVariable String id) {
		if (id.equals("17")) {
			throw new CustomerNotFoundException();
		}
		return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}

}
