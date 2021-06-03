package com.example.HRMS.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperienceToAddDto {

	private int userId;
	private int workplaceId;
	private int positionId;
	private int startingYear;
	private int quitYear;
}
