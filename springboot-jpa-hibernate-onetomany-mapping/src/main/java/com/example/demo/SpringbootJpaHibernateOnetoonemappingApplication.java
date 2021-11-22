package com.example.demo;

import java.util.HashSet;
import java.util.Set;

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
		EmployeeContact contact1 = new EmployeeContact();
		contact1.setPhoneNo(111111111111l);
		EmployeeContact contact2 = new EmployeeContact();
		contact2.setPhoneNo(22222222222222l);
		Set<EmployeeContact> contacts = new HashSet<>();
		contacts.add(contact1);
		contacts.add(contact2);
		employee.setEmployeeContacts(contacts);
		employeeRepository.save(employee);

	}

}
