package com.example.HRMS.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

	Employer getByEmail(String email);
	Employer getById(int id);
	List<Employer> getBySystemVerified(boolean systemVerified);
}
