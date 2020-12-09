package com.knowledgefactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private static final Logger logger = LogManager.getLogger(HelloController.class);

	@GetMapping("/test")
	public String main(Model model) {

		logger.trace("trace mode on");
		logger.debug("debug mode on");
		logger.info("info mode on");
		logger.warn("warn mode on");
		logger.error("error mode on");
		logger.fatal("fatal mode on");

		return "you are done";
	}

}
