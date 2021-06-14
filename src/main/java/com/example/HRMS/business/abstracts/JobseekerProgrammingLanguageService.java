package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobseekerProgrammingLanguage;
import com.example.HRMS.entities.dtos.JobseekerProgrammingLanguageToAddDto;

public interface JobseekerProgrammingLanguageService {

	DataResult<List<JobseekerProgrammingLanguage>> getByUserId(int userId);
	Result add(JobseekerProgrammingLanguageToAddDto jobseekerProgrammingLanguageToAddDto);
	Result delete(int id);
}
