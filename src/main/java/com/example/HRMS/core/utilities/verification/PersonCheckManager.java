package com.example.HRMS.core.utilities.verification;

import org.springframework.stereotype.Service;

@Service
public class PersonCheckManager implements PersonCheckService{

	@Override
	public boolean checkIfRealPerson(long nationalIdentity, String firstName, String lastName, int yearOfBirth) {
		return true;
	}

}
