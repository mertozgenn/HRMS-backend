package com.example.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer> {

}
