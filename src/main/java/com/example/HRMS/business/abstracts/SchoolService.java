package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.School;

public interface SchoolService {
	DataResult<List<School>> getAll();
	Result add(School school);
}
