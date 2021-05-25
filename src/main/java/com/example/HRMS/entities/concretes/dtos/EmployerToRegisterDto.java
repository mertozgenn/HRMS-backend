package com.example.HRMS.entities.concretes.dtos;

import lombok.Data;

@Data
public class EmployerToRegisterDto {

	private String companyName;
	private String website;
	private String email;
	private String phoneNumber;
	private String password;
	private String passwordAgain;
}
