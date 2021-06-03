package com.example.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {
	List<WorkExperience> getByUserId(int userId);
	List<WorkExperience> getByUserId(int userId, Sort sort);
}
