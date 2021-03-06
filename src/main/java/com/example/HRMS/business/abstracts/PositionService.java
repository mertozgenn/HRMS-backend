package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Position;

public interface PositionService {
	Result add(Position position);
	DataResult<List<Position>> getAll();
}
