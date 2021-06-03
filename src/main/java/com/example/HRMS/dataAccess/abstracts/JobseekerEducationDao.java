package com.example.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.JobseekerEducation;

public interface JobseekerEducationDao extends JpaRepository<JobseekerEducation, Integer> {

	List<JobseekerEducation> getByUserId(int userId);
	List<JobseekerEducation> getByUserId(int userId, Sort sort);
}
