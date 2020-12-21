package com.knf.dev.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
	private String employeename;

	@NotBlank
	private String password;

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
