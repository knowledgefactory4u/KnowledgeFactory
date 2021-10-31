package com.knf.dev.KotlinSpringExportPDF.repository

import com.knf.dev.KotlinSpringExportPDF.model.Employee
import org.springframework.data.repository.CrudRepository


interface EmployeeRepository : CrudRepository<Employee?, Long?>