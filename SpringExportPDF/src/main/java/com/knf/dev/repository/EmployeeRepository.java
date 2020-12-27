package com.knf.dev.repository;

import org.springframework.data.repository.CrudRepository;

import com.knf.dev.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}