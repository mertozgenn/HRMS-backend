package com.example.HRMS.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerToUpdateDto {
	
	private int userId;

	private String companyName;
	
	private String newCompanyName;
	
	private String website;
	
	private String newWebsite;
	
	private String email;
	
	private String newEmail;
	
	private String phoneNumber;
	
	private String newPhoneNumber;
	
}
