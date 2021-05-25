package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Jobseeker;
import com.example.HRMS.entities.concretes.dtos.JobseekerToRegisterDto;

public interface JobseekerService {

	Result add(JobseekerToRegisterDto jobseekerToRegisterDto);
	DataResult<List<Jobseeker>> getAll();
}
