package com.knf.dev.KotlinSpringExportPDF

import com.knf.dev.KotlinSpringExportPDF.model.Employee
import com.knf.dev.KotlinSpringExportPDF.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*


@SpringBootApplication
class KotlinSpringExportPdfApplication : CommandLineRunner {
	@Autowired
	var repository: EmployeeRepository? = null

	@Throws(Exception::class)
	override fun run(vararg args: String) {
		if (repository!!.count() == 0L) {
			// save a list of Employees
			repository!!.saveAll(
				Arrays.asList(
					Employee("Adam", "John"),
					Employee("Sibin", "M"),
					Employee("Arun", "Mohan"),
					Employee("Scott", "Morrison"),
					Employee("Hikaru", "Nakamura"),
					Employee("Ishivaka", "Yusuke")
				)
			)
		}
	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(KotlinSpringExportPdfApplication::class.java, *args)
		}
	}
}