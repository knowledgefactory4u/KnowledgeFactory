package com.knf.dev.controller


import com.knf.dev.repository.EmployeeRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import com.knf.dev.entity.Employee
import com.opencsv.CSVWriter
import com.opencsv.bean.StatefulBeanToCsv
import com.opencsv.bean.StatefulBeanToCsvBuilder
import org.springframework.http.HttpHeaders
import javax.servlet.http.HttpServletResponse

import java.util.ArrayList


@Controller
class EmployeeController(private val employeeRepository: EmployeeRepository) {

    @GetMapping("/export-employees")
    @Throws(Exception::class)
    fun exportCSV(response: HttpServletResponse) {
        //save Dummy Data
        saveDummyEmployees()
        // set file name and content type
        val filename = "employees.csv"
        response.contentType = "text/csv"
        response.setHeader(
            HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"$filename\""
        )

        // create a csv writer
        val writer: StatefulBeanToCsv<Employee> = StatefulBeanToCsvBuilder<Employee>(response.writer)
            .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR)
            .withOrderedResults(false).build()

        // write all employees to csv file
        writer.write(employeeRepository.findAll())
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
        employeeRepository.saveAll(employees)
    }
}