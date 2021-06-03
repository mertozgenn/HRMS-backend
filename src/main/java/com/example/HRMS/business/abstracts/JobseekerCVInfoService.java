package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobseekerCVInfo;

public interface JobseekerCVInfoService{

	DataResult<JobseekerCVInfo> getByUserId(int userId);
	Result add(JobseekerCVInfo jobseekerCVInfo);
}
