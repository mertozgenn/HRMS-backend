package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.SchoolDepartment;

public interface SchoolDepartmentService {

	DataResult<List<SchoolDepartment>> getAll();
	Result add(SchoolDepartment schoolDepartment);
}
