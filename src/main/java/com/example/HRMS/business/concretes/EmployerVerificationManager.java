package com.example.HRMS.business.concretes;

import com.example.HRMS.business.abstracts.EmployerService;
import com.example.HRMS.business.abstracts.EmployerVerificationService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.entities.concretes.Employer;

public class EmployerVerificationManager implements EmployerVerificationService {

	private EmployerService employerService;
	
	public EmployerVerificationManager(EmployerService employerService) {
		this.employerService = employerService;
	}
	@Override
	public Result verifyEmployer(String email) {
		Employer employer = this.employerService.getByEmail(email).getData();
		employer.setSystemVerified(true);
		this.employerService.update(employer);
		return new SuccessResult(Messages.employerVerified);
	}

}
