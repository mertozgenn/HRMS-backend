package com.example.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobseekerEducationToAddDto {

	private int userId;
	private int schoolId;
	private int schoolDepartmentId;
	private int startingYear;
	private int graduationYear;
}
