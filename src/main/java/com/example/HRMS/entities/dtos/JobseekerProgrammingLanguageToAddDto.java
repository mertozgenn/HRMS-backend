package com.example.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobseekerProgrammingLanguageToAddDto {

	private int userId;
	private int programmingLanguageOrTechnologyId;
	private int level;
}
