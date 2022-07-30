package com.knf.dev.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knf.dev.model.Employee;
import com.knf.dev.repository.EmployeeRepository;
import com.knf.dev.util.PDFGenerator;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping(value = "/export", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReport() throws IOException {

		List<Employee> employees = (List<Employee>) employeeRepository.findAll();

		ByteArrayInputStream bis = PDFGenerator.employeePDFReport(employees);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=employees.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
}