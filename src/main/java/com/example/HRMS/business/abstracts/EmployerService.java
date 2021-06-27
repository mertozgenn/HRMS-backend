package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Employer;
import com.example.HRMS.entities.concretes.EmployerToUpdate;
import com.example.HRMS.entities.dtos.EmployerToRegisterDto;
import com.example.HRMS.entities.dtos.EmployerToUpdateDto;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result update(EmployerToUpdate employerToUpdate);
	Result confirmUpdate(EmployerToUpdate employerToUpdate);
	DataResult<List<EmployerToUpdateDto>> getAllPendingUpdates();
	DataResult<EmployerToUpdate> getPendingUpdatesByUserId(int userId);
	Result add(EmployerToRegisterDto employerToRegisterDto);
	DataResult<Employer> getByEmail(String email);
	DataResult<Employer> getById(int id);
	DataResult<List<Employer>> getByNotApproved();
	DataResult<List<Employer>> getByApproved();
}
