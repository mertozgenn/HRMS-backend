package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.entities.concretes.Position;

public interface PositionService {
	List<Position> getAll();
}
