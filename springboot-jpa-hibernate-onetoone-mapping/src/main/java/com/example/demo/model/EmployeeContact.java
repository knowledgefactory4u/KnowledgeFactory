package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_contact")
public class EmployeeContact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	private Long phoneNo;

	public EmployeeContact() {
	}

	public Integer getId() {
		return id;
	}

	public EmployeeContact setId(Integer id) {
		this.id = id;
		return this;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "EmployeeContact [id=" + id + ", phoneNo=" + phoneNo + "]";
	}

}
