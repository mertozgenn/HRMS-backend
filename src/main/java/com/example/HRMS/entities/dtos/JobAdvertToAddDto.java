package com.example.HRMS.entities.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertToAddDto {

	private int userId;
	
	private int positionId;

	private int cityId;
	
	@NotBlank
	@NotNull
	private String jobDescription;
	
	private int minimumSalary;
	
	private int maximumSalary;
	
	private int openPosition;
	
	@NotNull
	private Date applicationDeadline;
	
	private boolean active;
}
