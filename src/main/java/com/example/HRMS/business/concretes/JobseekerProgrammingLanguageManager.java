package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.JobseekerProgrammingLanguageService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.JobseekerProgrammingLanguageDao;
import com.example.HRMS.entities.concretes.JobseekerProgrammingLanguage;
import com.example.HRMS.entities.concretes.ProgrammingLanguage;
import com.example.HRMS.entities.dtos.JobseekerProgrammingLanguageToAddDto;

@Service
public class JobseekerProgrammingLanguageManager implements JobseekerProgrammingLanguageService{

	private JobseekerProgrammingLanguageDao jobseekerProgrammingLanguageDao;
	
	public JobseekerProgrammingLanguageManager(JobseekerProgrammingLanguageDao jobseekerProgrammingLanguageDao) {
		this.jobseekerProgrammingLanguageDao = jobseekerProgrammingLanguageDao;
	}

	@Override
	public DataResult<List<JobseekerProgrammingLanguage>> getByUserId(int userId) {
		return new SuccessDataResult<List<JobseekerProgrammingLanguage>>(this.jobseekerProgrammingLanguageDao.getByUserId(userId));
	}

	@Override
	public Result add(JobseekerProgrammingLanguageToAddDto jobseekerProgrammingLanguageToAddDto) {
		JobseekerProgrammingLanguage jobseekerProgrammingLanguage = new JobseekerProgrammingLanguage();
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(jobseekerProgrammingLanguageToAddDto.getProgrammingLanguageOrTechnologyId());
		jobseekerProgrammingLanguage.setProgrammingLanguage(programmingLanguage);
		
		jobseekerProgrammingLanguage.setUserId(jobseekerProgrammingLanguageToAddDto.getUserId());
		jobseekerProgrammingLanguage.setLevel(jobseekerProgrammingLanguageToAddDto.getLevel());
		
		this.jobseekerProgrammingLanguageDao.save(jobseekerProgrammingLanguage);
		return new SuccessResult(Messages.added);
	}

}
