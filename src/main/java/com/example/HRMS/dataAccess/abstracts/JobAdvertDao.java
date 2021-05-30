package com.example.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	List<JobAdvert> getByActive(boolean active);
	List<JobAdvert> getByActive(boolean active, Sort sort);
	List<JobAdvert> getByActiveAndEmployer_id(boolean active, int id);
}
