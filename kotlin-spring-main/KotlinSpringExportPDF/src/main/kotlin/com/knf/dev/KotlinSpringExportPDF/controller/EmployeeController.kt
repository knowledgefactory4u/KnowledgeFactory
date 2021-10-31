package com.knf.dev.KotlinSpringExportPDF.controller

import com.knf.dev.KotlinSpringExportPDF.model.Employee
import com.knf.dev.KotlinSpringExportPDF.repository.EmployeeRepository
import com.knf.dev.KotlinSpringExportPDF.util.PDFGenerator.employeePDFReport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException


@RestController
@RequestMapping("/api/pdf")
class EmployeeController {
    @Autowired
    var employeeRepository: EmployeeRepository? = null

    @GetMapping(value = ["/employees"], produces = [MediaType.APPLICATION_PDF_VALUE])
    @Throws(
        IOException::class
    )
    fun employeeReport(): ResponseEntity<InputStreamResource> {
        val employees = employeeRepository!!.findAll() as List<Employee?>
        val bis = employeePDFReport(employees as List<Employee>)
        val headers = HttpHeaders()
        headers.add("Content-Disposition", "inline; filename=employees.pdf")
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
            .body(InputStreamResource(bis))
    }
}