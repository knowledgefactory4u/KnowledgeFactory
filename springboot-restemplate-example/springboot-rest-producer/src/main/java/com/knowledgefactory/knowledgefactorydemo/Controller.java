package com.knowledgefactory.knowledgefactorydemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	UserService service;

	@GetMapping(value = "/getUser")
	public ResponseEntity<Map<Integer, User>> listAllUsers() {

		return new ResponseEntity<>(service.getUser(), HttpStatus.OK);
	}

	@PostMapping(value = "/deleteUser")
	public ResponseEntity<Map<Integer, User>> deleteUser(@RequestBody Key key) {

		return new ResponseEntity<>(service.deleteuser(key.getKey()), HttpStatus.OK);
	}

}
