package com.example.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.JobseekerLanguage;

public interface JobseekerLanguageDao extends JpaRepository<JobseekerLanguage, Integer> {

	List<JobseekerLanguage> getByUserId(int userId);
}
