package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {
	Image getByUserId(int userId);
}
