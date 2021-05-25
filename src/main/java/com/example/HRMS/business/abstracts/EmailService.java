package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.utilities.results.Result;

public interface EmailService {
	Result sendVerificationEmail(String email);
	Result verify(String email);
}
