package com.example.HRMS.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.Jobseeker;

public interface JobseekerDao extends JpaRepository<Jobseeker, Integer> {

	Jobseeker getByNationalIdentity(String nationalIdentity);
	Jobseeker getByEmail(String email);
	Jobseeker getById(int id);
}
