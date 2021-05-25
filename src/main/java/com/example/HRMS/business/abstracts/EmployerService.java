package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Employer;
import com.example.HRMS.entities.concretes.dtos.EmployerToRegisterDto;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result update(Employer employer);
	Result add(EmployerToRegisterDto employerToRegisterDto);
	DataResult<Employer> getByEmail(String email);
}