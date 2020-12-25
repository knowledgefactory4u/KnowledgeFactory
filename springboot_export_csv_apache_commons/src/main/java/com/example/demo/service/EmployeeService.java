package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.helper.CSVHelper;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> fetchAll() {
		return (List<Employee>) employeeRepository.findAll();

	}

	public ByteArrayInputStream load() {
		List<Employee> tutorials = fetchAll();

		ByteArrayInputStream in = CSVHelper.employeesToCSV(tutorials);
		return in;
	}
}
