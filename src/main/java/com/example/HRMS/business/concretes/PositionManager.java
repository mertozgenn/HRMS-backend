package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.PositionService;
import com.example.HRMS.dataAccess.abstracts.PositionDao;
import com.example.HRMS.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	@Override
	public List<Position> getAll() {
		return this.positionDao.findAll();
	}

}
