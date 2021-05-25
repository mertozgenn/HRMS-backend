package com.example.HRMS.entities.concretes.dtos;

import lombok.Data;

@Data
public class JobseekerToRegisterDto {
	
	private String firstName;
	private String lastName;
	private String nationalIdentity;
	private int yearOfBirth;
	private String email;
	private String password;
	private String passwordAgain;
}
