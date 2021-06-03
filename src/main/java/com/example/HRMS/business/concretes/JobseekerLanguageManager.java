package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.JobseekerLanguageService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.JobseekerLanguageDao;
import com.example.HRMS.entities.concretes.JobseekerLanguage;
import com.example.HRMS.entities.concretes.Language;
import com.example.HRMS.entities.dtos.JobseekerLanguageToAddDto;

@Service
public class JobseekerLanguageManager implements JobseekerLanguageService{

	private JobseekerLanguageDao jobseekerLanguageDao;
	
	public JobseekerLanguageManager(JobseekerLanguageDao jobseekerLanguageDao) {
		this.jobseekerLanguageDao = jobseekerLanguageDao;
	}

	@Override
	public DataResult<List<JobseekerLanguage>> getByUserId(int userId) {
		return new SuccessDataResult<List<JobseekerLanguage>>(this.jobseekerLanguageDao.getByUserId(userId));
	}

	@Override
	public Result add(JobseekerLanguageToAddDto jobseekerLanguageToAdd) {
		JobseekerLanguage jobseekerLanguage = new JobseekerLanguage();
		
		Language language = new Language();
		language.setId(jobseekerLanguageToAdd.getLanguageId());
		jobseekerLanguage.setLanguage(language);
		
		jobseekerLanguage.setLevel(jobseekerLanguageToAdd.getLevel());
		jobseekerLanguage.setUserId(jobseekerLanguageToAdd.getUserId());
		
		this.jobseekerLanguageDao.save(jobseekerLanguage);
		return new SuccessResult(Messages.added);
	}
}
