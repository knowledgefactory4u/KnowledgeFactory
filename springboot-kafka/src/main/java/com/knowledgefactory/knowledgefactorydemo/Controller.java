package com.knowledgefactory.knowledgefactorydemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api
public class Controller {

	@Autowired
	UserService service;

	@GetMapping("/user")
	@ApiOperation(value = "Find all User", notes = "Retrieving the collection of User", response = User[].class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Success", response = User[].class) })

	public List<User> findAll() {
		return service.getTopicList();
	}

}