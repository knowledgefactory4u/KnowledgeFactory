package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employeeId")
	private Integer id;
	@Column(name = "name")
	private String name;
	private Integer salary;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private EmployeeContact employeeContact;

	public Employee() {
	}

	public EmployeeContact getEmployeeContact() {
		return employeeContact;
	}

	public void setEmployeeContact(EmployeeContact employeeContact) {
		this.employeeContact = employeeContact;
	}

	public Integer getId() {
		return id;
	}

	public Employee setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getSalary() {
		return salary;
	}

	public Employee setSalary(Integer salary) {
		this.salary = salary;
		return this;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", employeeContact=" + employeeContact
				+ "]";
	}

}