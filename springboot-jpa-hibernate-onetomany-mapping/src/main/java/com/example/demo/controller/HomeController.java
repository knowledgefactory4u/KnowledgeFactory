package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("employee")
public class HomeController {
	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping
	public List<Employee> findAll() {

		return employeeRepository.findAll();

	}

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);

	}

	@GetMapping("/{employeeName}")
	public List<Employee> findByName(@PathVariable("employeeName") String employeeName) {
		return employeeRepository.findByName(employeeName);

	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		try {
			employeeRepository.deleteById(id);
			return "Deleted successfully";
		} catch (Exception e) {
			return "Failed to delete";
		}
	}

}
