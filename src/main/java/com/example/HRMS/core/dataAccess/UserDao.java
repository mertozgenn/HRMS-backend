package com.example.HRMS.core.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	User getById(int id);
}
