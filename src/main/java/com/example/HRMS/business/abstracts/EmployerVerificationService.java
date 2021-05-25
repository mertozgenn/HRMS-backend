package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.utilities.results.Result;

public interface EmployerVerificationService {
	Result verifyEmployer(String email);
}
