package com.example.HRMS.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.JobseekerCVInfo;

public interface JobseekerCVInfoDao extends JpaRepository<JobseekerCVInfo, Integer> {

	JobseekerCVInfo getByUserId(int userId);
}
