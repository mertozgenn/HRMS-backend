package com.example.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.JobseekerProgrammingLanguage;

public interface JobseekerProgrammingLanguageDao extends JpaRepository<JobseekerProgrammingLanguage, Integer> {

	List<JobseekerProgrammingLanguage> getByUserId(int userId);
}
