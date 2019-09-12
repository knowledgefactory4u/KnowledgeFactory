package com.knowledgefactory.knowledgefactorydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {

	@Autowired
	ServiceLayer service;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<String> listAllUsers() {

		return new ResponseEntity<String>(service.getService(), HttpStatus.OK);
	}
}
