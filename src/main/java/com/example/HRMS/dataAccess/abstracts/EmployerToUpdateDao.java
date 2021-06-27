package com.example.HRMS.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.HRMS.entities.concretes.EmployerToUpdate;
import com.example.HRMS.entities.dtos.EmployerToUpdateDto;


public interface EmployerToUpdateDao extends JpaRepository<EmployerToUpdate, Integer> {

	EmployerToUpdate getByUserId(int userId);
	
	@Query("Select new com.example.HRMS.entities.dtos.EmployerToUpdateDto(e.id, e.companyName, u.newCompanyName,"
			+ "e.website, u.newWebsite, e.email, u.newEmail, e.phoneNumber, u.newPhoneNumber) From EmployerToUpdate u"
			+ " Inner Join u.employer e")
	List<EmployerToUpdateDto> getAllPendingUpdate();
}
