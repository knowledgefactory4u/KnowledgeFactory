package com.knf.dev.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knf.dev.demo.helper.WordHelper;

@RestController
@RequestMapping("/api")
public class WordController {

	@GetMapping(value = "/word", 
			produces = "application/vnd.openxmlformats-"
					+ "officedocument.wordprocessingml.document")
	public ResponseEntity<InputStreamResource> word() 
			throws IOException, InvalidFormatException {

		ByteArrayInputStream bis = WordHelper.generateWord();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", 
				"inline; filename=mydoc.docx");
		return ResponseEntity.ok().headers(headers).
				body(new InputStreamResource(bis));
	}
}
