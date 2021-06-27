package com.example.HRMS.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.example.HRMS.entities.dtos.JobAdvertToAddDto;

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
	public DataResult<JobAdvert> getById(int id){
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findById(id).get());
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
		
		jobAdvert.setApproved(false);
		jobAdvert.setActive(true);
		jobAdvert.setApplicationDeadline(jobAdvertToAdd.getApplicationDeadline());
		jobAdvert.setJobDescription(jobAdvertToAdd.getJobDescription());
		jobAdvert.setMaximumSalary(jobAdvertToAdd.getMaximumSalary());
		jobAdvert.setMinimumSalary(jobAdvertToAdd.getMinimumSalary());
		jobAdvert.setOpenPosition(jobAdvertToAdd.getOpenPosition());
		jobAdvert.setPublishingDate(new Date());
		jobAdvert.setFullTime(jobAdvertToAdd.isFullTime());
		jobAdvert.setPartTime(jobAdvertToAdd.isPartTime());
		jobAdvert.setWorkplaceWork(jobAdvertToAdd.isWorkplaceWork());
		jobAdvert.setRemoteWork(jobAdvertToAdd.isRemoteWork());
		
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult(Messages.added);
	}
	@Override
	public DataResult<List<JobAdvert>> getByActiveAndApproved() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActiveAndApproved(true, true), Messages.dataListed);
	}
	@Override
	public DataResult<List<JobAdvert>> getByActiveAndApprovedAndEmployerId(int id) {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActiveAndApprovedAndEmployer_id(true, true, id));
	}
	@Override
	public DataResult<List<JobAdvert>> getByActiveAndApprovedSortedByDateDesc(int pageNo, int pageSize) {
		Sort sort = Sort.by(Sort.Direction.DESC, "publishingDate");
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByActiveAndApproved(true, true, pageable));
	}
	@Override
	public DataResult<List<JobAdvert>> getByEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployer_id(id));
	}
	@Override
	public DataResult<List<JobAdvert>> getByNotApproved() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByApproved(false));
	}
	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult();
	}
	@Override
	public DataResult<Integer> getPageCount(int pageSize) {
		int pageCount = (int) Math.ceil((double)jobAdvertDao.count() / pageSize);
		return new SuccessDataResult<Integer>(pageCount);
	}
}
