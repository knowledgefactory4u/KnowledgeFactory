package com.knowledgefactory.knowledgefactorydemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> listAllUsers() {
		
		return new ResponseEntity<String>("Greetings from knowledgefactory", HttpStatus.OK);
	}
}
