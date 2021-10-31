package com.knf.dev.helper

import java.io.IOException

import java.io.ByteArrayInputStream

import com.knf.dev.entity.Employee

import java.io.PrintWriter

import org.apache.commons.csv.CSVPrinter

import org.apache.commons.csv.CSVFormat
import java.io.ByteArrayOutputStream
import java.util.*


object CSVHelper {
    fun employeesToCSV(employees: List<Employee>): ByteArrayInputStream {
        val format = CSVFormat.DEFAULT.withHeader("ID", "Name", "Email", "Age", "Country", "Role")
        try {
            ByteArrayOutputStream().use({ out ->
                CSVPrinter(
                    PrintWriter(out),
                    format
                ).use { csvPrinter ->
                    for (emp in employees) {
                        val data: List<String?> = Arrays.asList(
                            emp.id.toString(),
                            emp.name, emp.email,
                            java.lang.String.valueOf(emp.age), emp.country,
                            emp.role
                        )
                        csvPrinter.printRecord(data)
                    }
                    csvPrinter.flush()
                    return ByteArrayInputStream(out.toByteArray())
                }
            })
        } catch (e: IOException) {
            throw RuntimeException(
                "fail to import data to CSV file: "
                        + e.message
            )
        }
    }
}
