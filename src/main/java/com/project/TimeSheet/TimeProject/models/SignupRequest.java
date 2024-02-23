package com.project.TimeSheet.TimeProject.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignupRequest {

	@NotBlank
	@Size(min = 3 ,max = 20)
	private String firstName;
	@NotBlank
	@Size(min = 3 ,max = 20)
	private String lastName;
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	@NotBlank
	@Pattern(regexp="^\\+(?:[0-9] ?){6,14}[0-9]$")
	private String mobile;
	@NotBlank
	@Size(min = 6, max = 20)
	private String password;
	private String roles;
	
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRoles() {
		return roles;
	}
	
	public void setRoles(String roles) {
		this.roles = roles;
	}

	public SignupRequest(@NotBlank @Size(min = 3, max = 20) String firstName,
			@NotBlank @Size(min = 3, max = 20) String lastName, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$") String mobile,
			@NotBlank @Size(min = 6, max = 20) String password, String roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.roles = roles;
	}

	public SignupRequest() {
	}

	@Override
	public String toString() {
		return "{firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobile="
				+ mobile + ", password=" + password + ", roles=" + roles + "}";
	}
	
}
