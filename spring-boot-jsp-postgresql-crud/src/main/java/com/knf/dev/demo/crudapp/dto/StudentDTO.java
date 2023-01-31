package com.knf.dev.demo.crudapp.dto;


import com.knf.dev.demo.crudapp.model.Student;

public class StudentDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String emailId;
	
	public StudentDTO() {
	}
	
	public StudentDTO(Student employee) {
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.emailId = employee.getEmailId();
		this.id = employee.getId();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
