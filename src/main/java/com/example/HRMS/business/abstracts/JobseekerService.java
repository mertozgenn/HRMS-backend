package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Jobseeker;
import com.example.HRMS.entities.dtos.JobseekerToRegisterDto;

public interface JobseekerService {

	Result add(JobseekerToRegisterDto jobseekerToRegisterDto);
	DataResult<List<Jobseeker>> getAll();
	DataResult<Jobseeker> getByEmail(String email);
	DataResult<Jobseeker> getById(int id);
}
