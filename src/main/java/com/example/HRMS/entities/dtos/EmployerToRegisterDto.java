package com.example.HRMS.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EmployerToRegisterDto {

	@NotBlank
	@NotNull
	private String companyName;
	
	@NotBlank
	@NotNull
	private String website;
	
	@NotBlank
	@NotNull
	@Email
	private String email;
	
	@NotBlank
	@NotNull
	private String phoneNumber;
	
	@NotBlank
	@NotNull
	private String password;
	
	@NotBlank
	@NotNull
	private String passwordAgain;
}
