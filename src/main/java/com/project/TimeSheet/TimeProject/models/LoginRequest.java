package com.project.TimeSheet.TimeProject.models;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

	@NotBlank
	private String email;
	private String password;
	
	@NotBlank
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
