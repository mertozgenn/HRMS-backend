package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.Workplace;

public interface WorkplaceDao extends JpaRepository<Workplace, Integer>{
	
}
