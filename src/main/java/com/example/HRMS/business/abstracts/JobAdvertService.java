package com.example.HRMS.business.abstracts;

import java.util.List;


import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobAdvert;
import com.example.HRMS.entities.dtos.JobAdvertToAddDto;

public interface JobAdvertService {

	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getByActiveAndApproved();
	DataResult<List<JobAdvert>> getByActiveAndApprovedSortedByDateDesc(int pageNo, int pageSize);
	DataResult<Integer> getPageCount(int pageSize);
	DataResult<List<JobAdvert>> getByActiveAndApprovedAndEmployerId(int id);
	DataResult<List<JobAdvert>> getByEmployerId(int id);
	DataResult<List<JobAdvert>> getByNotApproved();
	Result add(JobAdvertToAddDto jobAdvert);
	Result update(JobAdvert jobAdvert);
	DataResult<JobAdvert> getById(int id);
}
