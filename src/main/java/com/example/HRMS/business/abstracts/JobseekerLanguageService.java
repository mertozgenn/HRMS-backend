package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobseekerLanguage;
import com.example.HRMS.entities.dtos.JobseekerLanguageToAddDto;

public interface JobseekerLanguageService {

	DataResult<List<JobseekerLanguage>> getByUserId(int userId);
	Result add(JobseekerLanguageToAddDto jobseekerLanguageToAdd);
	Result delete(int id);
}
