package com.example.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite, Integer> {

	List<Favorite> getByUserId(int userId);
}
