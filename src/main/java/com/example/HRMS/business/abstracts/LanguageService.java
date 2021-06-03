package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Language;

public interface LanguageService {

	DataResult<List<Language>> getAll();
	Result add(Language language);
}
