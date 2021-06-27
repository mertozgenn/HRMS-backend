package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.SystemEmployeeService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.SystemEmployeeDao;
import com.example.HRMS.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {
	
	private SystemEmployeeDao systemEmployeeDao;
	
	@Autowired
	SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao){
		this.systemEmployeeDao = systemEmployeeDao;
	}

	@Override
	public Result add(SystemEmployee systemEmployee) {
		this.systemEmployeeDao.save(systemEmployee);
		return new SuccessResult(Messages.added);
	}

	@Override
	public DataResult<List<SystemEmployee>> getAll() {
		return new SuccessDataResult<List<SystemEmployee>>(this.systemEmployeeDao.findAll());
	}

}
