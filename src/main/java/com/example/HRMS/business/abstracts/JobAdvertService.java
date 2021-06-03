package com.example.HRMS.business.abstracts;

import java.util.List;


import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobAdvert;
import com.example.HRMS.entities.dtos.JobAdvertToAddDto;

public interface JobAdvertService {

	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getByActive(boolean active);
	DataResult<List<JobAdvert>> getByActiveSortedByDateDesc(boolean active);
	DataResult<List<JobAdvert>> getByActiveAndEmployerId(boolean active, int id);
	Result add(JobAdvertToAddDto jobAdvert);
}
