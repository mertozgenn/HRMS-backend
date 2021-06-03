package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.WorkExperience;
import com.example.HRMS.entities.dtos.WorkExperienceToAddDto;

public interface WorkExperienceService {
	DataResult<List<WorkExperience>> getByUserId(int userId);
	DataResult<List<WorkExperience>> getByUserIdSortedByQuitYearDesc(int userId);
	Result add(WorkExperienceToAddDto workExperienceToAdd);
}
