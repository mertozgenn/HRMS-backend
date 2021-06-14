package com.example.HRMS.business.abstracts;


import java.util.List;


import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobseekerEducation;
import com.example.HRMS.entities.dtos.JobseekerEducationToAddDto;

public interface JobseekerEducationService {

	DataResult<List<JobseekerEducation>> getByUserId(int userId);
	DataResult<List<JobseekerEducation>> getByUserIdSortedByGraduationYearDesc(int userId);
	Result add(JobseekerEducationToAddDto jobseekerEducationToAdd);
	Result delete(int id);
}
