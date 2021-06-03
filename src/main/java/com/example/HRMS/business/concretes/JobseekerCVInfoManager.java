package com.example.HRMS.business.concretes;

import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.JobseekerCVInfoService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.JobseekerCVInfoDao;
import com.example.HRMS.entities.concretes.JobseekerCVInfo;

@Service
public class JobseekerCVInfoManager implements JobseekerCVInfoService{

	private JobseekerCVInfoDao jobseekerCVInfoDao;
	
	public JobseekerCVInfoManager(JobseekerCVInfoDao jobseekerCVInfoDao) {
		this.jobseekerCVInfoDao = jobseekerCVInfoDao;
	}

	@Override
	public DataResult<JobseekerCVInfo> getByUserId(int userId) {
		return new SuccessDataResult<JobseekerCVInfo>(this.jobseekerCVInfoDao.getByUserId(userId));
	}

	@Override
	public Result add(JobseekerCVInfo jobseekerCVInfo) {
		this.jobseekerCVInfoDao.save(jobseekerCVInfo);
		return new SuccessResult(Messages.added);
	}

}
