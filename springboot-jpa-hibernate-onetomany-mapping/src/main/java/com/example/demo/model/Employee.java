package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "name")
	private String name;
	private Integer salary;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "empId")
	private Set<EmployeeContact> employeeContacts;

	public Set<EmployeeContact> getEmployeeContacts() {
		return employeeContacts;
	}

	public void setEmployeeContacts(Set<EmployeeContact> employeeContacts) {
		this.employeeContacts = employeeContacts;
	}

	public Employee() {
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
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", employeeContacts=" + employeeContacts
				+ "]";
	}

}