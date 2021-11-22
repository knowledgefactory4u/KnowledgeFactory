package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeContact;
import com.example.demo.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootJpaHibernateOnetoonemappingApplication implements CommandLineRunner {
	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaHibernateOnetoonemappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setName("sibin");
		employee.setSalary(12500);
		EmployeeContact contact = new EmployeeContact();
		contact.setPhoneNo(111111111111l);
		employee.setEmployeeContact(contact);
		employeeRepository.save(employee);

	}

}
