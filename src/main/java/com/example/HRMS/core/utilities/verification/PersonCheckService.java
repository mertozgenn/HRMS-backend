package com.example.HRMS.core.utilities.verification;


public interface PersonCheckService {

	boolean checkIfRealPerson(long nationalIdentity, String firstName, String lastName, int yearOfBirth);
}
