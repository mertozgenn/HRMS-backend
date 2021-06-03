package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	Result add(ProgrammingLanguage programmingLanguage);
	DataResult<List<ProgrammingLanguage>> getAll();
}
