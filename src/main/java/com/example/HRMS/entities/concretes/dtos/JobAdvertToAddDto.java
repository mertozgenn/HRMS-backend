package com.example.HRMS.entities.concretes.dtos;

import java.util.Date;

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
	private String jobDescription;
	private int minimumSalary;
	private int maximumSalary;
	private int openPosition;
	private Date applicationDeadline;
	private boolean active;
}
