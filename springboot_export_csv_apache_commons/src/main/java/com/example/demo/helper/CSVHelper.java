package com.example.demo.helper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import com.example.demo.model.Employee;

public class CSVHelper {

	public static ByteArrayInputStream employeesToCSV(List<Employee> employees) {
		final CSVFormat format = CSVFormat.DEFAULT.withHeader("ID", "Name", "Email", "Age", "Country", "Role");

		try (

				ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
			for (Employee emp : employees) {
				List<String> data = Arrays.asList(String.valueOf(emp.getId()), emp.getName(), emp.getEmail(),
						String.valueOf(emp.getAge()), emp.getCountry(), emp.getRole());

				csvPrinter.printRecord(data);
			}

			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
	}
}