package com.example.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobseekerLanguageToAddDto {

	private int userId;
	private int languageId;
	private int level;
}
