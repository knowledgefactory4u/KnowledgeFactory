package com.knowledgefactory.knowledgefactorydemo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@Autowired
	private MyResourceHttpRequestHandler handler;
	private final static File MP4_FILE = new File("D:\\videofiles\\video1.mp4");

	// supports byte-range requests
	@GetMapping("/index")
	public String home() {

		return "index";
	}

	// supports byte-range requests
	@GetMapping("/byterange")
	public void byterange( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute(MyResourceHttpRequestHandler.ATTR_FILE, MP4_FILE);
		handler.handleRequest(request, response);
	}

	/*
	 * // does not support byte-range requests
	 * 
	 * @GetMapping(path = "/plain", produces = "video/mp4") public
	 * FileSystemResource plain() {
	 * 
	 * return new FileSystemResource(MP4_FILE); }
	 */

}
