package com.example.HRMS.business.abstracts;

import java.util.List;


import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.SystemEmployee;

public interface SystemEmployeeService{

	Result add(SystemEmployee systemEmployee);
	DataResult<List<SystemEmployee>> getAll();
}
