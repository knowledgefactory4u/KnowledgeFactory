package com.knf.dev.controller

import org.springframework.http.HttpHeaders

import org.springframework.http.ResponseEntity

import org.springframework.core.io.InputStreamResource

import javax.servlet.http.HttpServletResponse

import org.springframework.web.bind.annotation.GetMapping

import com.knf.dev.service.EmployeeService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller


@Controller
class EmployeeController {
    @Autowired
    var employeeService: EmployeeService? = null
    @GetMapping("/export-employees")
    @Throws(Exception::class)
    fun exportCSV(response: HttpServletResponse?): ResponseEntity<InputStreamResource> {
        val filename = "employees.csv"
        val file = InputStreamResource(employeeService!!.load())
        return ResponseEntity.ok().header(
            HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=$filename"
        )
            .contentType(MediaType.parseMediaType("application/csv")).body(file)
    }
}
