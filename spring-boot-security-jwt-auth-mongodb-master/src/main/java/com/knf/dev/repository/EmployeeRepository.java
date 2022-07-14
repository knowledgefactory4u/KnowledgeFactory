package com.knf.dev.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.knf.dev.models.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	Optional<Employee> findByEmployeename(String employeename);

	Boolean existsByEmployeename(String employeename);

	Boolean existsByEmail(String email);
}
