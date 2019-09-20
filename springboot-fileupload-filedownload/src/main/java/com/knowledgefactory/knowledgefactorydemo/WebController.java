package com.knowledgefactory.knowledgefactorydemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	
	@GetMapping({  "/","/view" })
	public String listAllUsers() {

		return "index";
	}
}
