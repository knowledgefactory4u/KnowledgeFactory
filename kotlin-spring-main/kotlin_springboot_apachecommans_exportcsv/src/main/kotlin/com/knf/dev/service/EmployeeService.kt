package com.knf.dev.service

import java.io.ByteArrayInputStream

import com.knf.dev.entity.Employee
import com.knf.dev.helper.CSVHelper
import com.knf.dev.helper.CSVHelper.employeesToCSV

import com.knf.dev.repository.EmployeeRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class EmployeeService {
    @Autowired
    var employeeRepository: EmployeeRepository? = null
    fun fetchAll(): List<Employee> {
        return employeeRepository!!.findAll()
    }

    fun load(): ByteArrayInputStream {
        //save Dummy Data
        saveDummyEmployees()
        val tutorials = fetchAll()
        return CSVHelper.employeesToCSV(tutorials)
    }

    //save Dummy Data
    fun saveDummyEmployees() {

        val employees: MutableList<Employee> = ArrayList()

        // create dummy employees

        // create dummy employees
        employees.add(
            Employee(
                "Dummy-1", "dummy1@example.com",
                "India", 35, "Lead Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-2", "dummy2@srovoki.me",
                "USA", 25, "Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-3", "dummy3@gmail.com",
                "Japan", 29, "Sr.Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-1", "dummy1@example.com",
                "India", 35, "Lead Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-2", "dummy2@srovoki.me",
                "USA", 25, "Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-3", "dummy3@gmail.com",
                "Japan", 29, "Sr.Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-1", "dummy1@example.com",
                "India", 35, "Lead Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-2", "dummy2@srovoki.me",
                "USA", 25, "Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-3", "dummy3@gmail.com",
                "Japan", 29, "Sr.Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-1", "dummy1@example.com",
                "India", 35, "Lead Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-2", "dummy2@srovoki.me",
                "USA", 25, "Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-3", "dummy3@gmail.com",
                "Japan", 29, "Sr.Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-1", "dummy1@example.com",
                "India", 35, "Lead Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-2", "dummy2@srovoki.me",
                "USA", 25, "Tester"
            )
        )
        employees.add(
            Employee(
                "Dummy-3", "dummy3@gmail.com",
                "Japan", 29, "Sr.Tester"
            )
        )
        employeeRepository?.saveAll(employees)
    }
}