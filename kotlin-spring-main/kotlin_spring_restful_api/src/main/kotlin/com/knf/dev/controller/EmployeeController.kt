package com.knf.dev.controller


import com.knf.dev.model.Employee
import com.knf.dev.repository.EmployeeRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/v1/")
class EmployeeController(private val employeeRepository: EmployeeRepository) {

    @GetMapping("/employees")
    fun getAllEmployees(): List<Employee> =
            employeeRepository.findAll()

    @PostMapping("/employees")
    fun createNewEmployee(@RequestBody employee: Employee): Employee =
            employeeRepository.save(employee)

    @GetMapping("/employees/{id}")
    fun getEmployeeById(@PathVariable(value = "id") employeeId: String): ResponseEntity<Employee> {
        return employeeRepository.findById(employeeId).map { emp ->
            ResponseEntity.ok(emp)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/employees/{id}")
    fun updateEmployeeById(@PathVariable(value = "id") employeeId: String,
                           @RequestBody newEmployee: Employee): ResponseEntity<Employee> {

        return employeeRepository.findById(employeeId).map { existingEmployee ->
            val updatedEmployee: Employee = existingEmployee
                    .copy(firstName = newEmployee.firstName, lastName = newEmployee.lastName, emailId = newEmployee.emailId)
            ResponseEntity.ok().body(employeeRepository.save(updatedEmployee))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployeeById(@PathVariable(value = "id") employeeId: String): ResponseEntity<Void> {
        return employeeRepository.findById(employeeId).map { emp ->
            employeeRepository.delete(emp)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }
}