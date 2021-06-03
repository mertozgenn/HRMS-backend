package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.WorkplaceService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.WorkplaceDao;
import com.example.HRMS.entities.concretes.Workplace;

@Service
public class WorkplaceManager implements WorkplaceService{

	private WorkplaceDao workplaceDao;
	
	public WorkplaceManager(WorkplaceDao workplaceDao) {
		this.workplaceDao = workplaceDao;
	}

	@Override
	public DataResult<List<Workplace>> getAll() {
		return new SuccessDataResult<List<Workplace>>(this.workplaceDao.findAll());
	}

	@Override
	public Result add(Workplace workplace) {
		this.workplaceDao.save(workplace);
		return new SuccessResult();
	}

}
