package com.example.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	List<JobAdvert> getByActiveAndApproved(boolean active, boolean approved);
	List<JobAdvert> getByActiveAndApproved(boolean active, boolean approved, Pageable pageable);
	List<JobAdvert> getByActiveAndApprovedAndEmployer_id(boolean active, boolean approved, int id);
	List<JobAdvert> getByEmployer_id(int id);
	List<JobAdvert> getByApproved(boolean approved);
}
