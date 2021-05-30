package com.example.HRMS.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.JobAdvertService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.JobAdvertDao;
import com.example.HRMS.entities.concretes.City;
import com.example.HRMS.entities.concretes.Employer;
import com.example.HRMS.entities.concretes.JobAdvert;
import com.example.HRMS.entities.concretes.Position;
import com.example.HRMS.entities.concretes.dtos.JobAdvertToAddDto;

@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		this.jobAdvertDao = jobAdvertDao;
	}
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}
	@Override
	public Result add(JobAdvertToAddDto jobAdvertToAdd) {
		JobAdvert jobAdvert = new JobAdvert();
		
		Employer employer = new Employer();
		employer.setId(jobAdvertToAdd.getUserId());
		jobAdvert.setEmployer(employer);;
		
		City city = new City();
		city.setId(jobAdvertToAdd.getCityId());
		jobAdvert.setCity(city);
		
		Position position = new Position();
		position.setId(jobAdvertToAdd.getPositionId());
		jobAdvert.setPosition(position);
		
		jobAdvert.setActive(jobAdvertToAdd.isActive());
		jobAdvert.setApplicationDeadline(jobAdvertToAdd.getApplicationDeadline());
		jobAdvert.setJobDescription(jobAdvertToAdd.getJobDescription());
		jobAdvert.setMaximumSalary(jobAdvertToAdd.getMaximumSalary());
		jobAdvert.setMinimumSalary(jobAdvertToAdd.getMinimumSalary());
		jobAdvert.setOpenPosition(jobAdvertToAdd.getOpenPosition());
		jobAdvert.setPublishingDate(new Date());
		
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult(Messages.added);
	}
	@Override
	public DataResult<List<JobAdvert>> getByActive(boolean active) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActive(active), Messages.dataListed);
	}
	@Override
	public DataResult<List<JobAdvert>> getByActiveAndEmployerId(boolean active, int id) {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActiveAndEmployer_id(active, id));
	}
	@Override
	public DataResult<List<JobAdvert>> getByActiveSortedByDateDesc(boolean active) {
		Sort sort = Sort.by(Sort.Direction.DESC, "publishingDate");
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActive(active, sort));
	}

}
