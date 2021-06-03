package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.EmailService;
import com.example.HRMS.business.abstracts.JobseekerService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.business.BusinessRules;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.ErrorDataResult;
import com.example.HRMS.core.utilities.results.ErrorResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.core.utilities.verification.PersonCheckService;
import com.example.HRMS.dataAccess.abstracts.JobseekerDao;
import com.example.HRMS.entities.concretes.Jobseeker;
import com.example.HRMS.entities.dtos.JobseekerToRegisterDto;

@Service
public class JobseekerManager implements JobseekerService {

	private JobseekerDao jobseekerDao;
	private PersonCheckService personCheckService;
	private EmailService emailService;
	
	@Autowired
	public JobseekerManager(JobseekerDao jobseekerDao, PersonCheckService personCheckService, EmailService emailService) {
		this.jobseekerDao = jobseekerDao;
		this.personCheckService = personCheckService;
		this.emailService = emailService;
	}
	
	@Override
	public Result add(JobseekerToRegisterDto jobseekerToRegisterDto) {
		if (!jobseekerToRegisterDto.getPassword().equals(jobseekerToRegisterDto.getPasswordAgain())) {
			return new ErrorResult(Messages.passwordMatchError);
		}
		Jobseeker jobseeker = new Jobseeker(jobseekerToRegisterDto.getEmail(), jobseekerToRegisterDto.getPassword(), 
				jobseekerToRegisterDto.getFirstName(), jobseekerToRegisterDto.getLastName(), 
				jobseekerToRegisterDto.getNationalIdentity(), jobseekerToRegisterDto.getYearOfBirth());
		Result result = BusinessRules.run(checkEmailExists(jobseeker.getEmail()),
				checkNationalIdentityExists(jobseeker.getNationalIdentity()), checkIfRealPerson(jobseeker.getNationalIdentity()
						,jobseeker.getFirstName(), jobseeker.getLastName(), jobseeker.getYearOfBirth()));
		if (result != null) {
			return result;
		}
		this.jobseekerDao.save(jobseeker);
		this.emailService.sendVerificationEmail(jobseekerToRegisterDto.getEmail());
		return new SuccessResult(Messages.added);
	}
	
	private Result checkEmailExists(String email) {
		if (this.jobseekerDao.getByEmail(email) != null) {
			return new ErrorResult(Messages.emailExists);
		}
		return new SuccessResult();
	}
	
	private Result checkNationalIdentityExists(String nationalIdentity) {
		if (this.jobseekerDao.getByNationalIdentity(nationalIdentity) != null) {
			return new ErrorResult(Messages.nationalIdentityExists);
		}
		return new SuccessResult();
	}
	
	private Result checkIfRealPerson(String nationalIdentity, String firstName, String lastName, int yearOfBirth) {
		if (!this.personCheckService.checkIfRealPerson(Long.parseLong(nationalIdentity), 
				firstName, lastName, yearOfBirth)) {
			return new ErrorResult(Messages.personInfoError);
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Jobseeker>> getAll() {
		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.findAll(), Messages.dataListed);
	}

	@Override
	public DataResult<Jobseeker> getByEmail(String email) {
		Jobseeker jobseeker = this.jobseekerDao.getByEmail(email);
		if (jobseeker == null) {
			return new ErrorDataResult<Jobseeker>(Messages.notFound);
		}
		return new SuccessDataResult<Jobseeker>(jobseeker);
	}

	@Override
	public DataResult<Jobseeker> getById(int id) {
		Jobseeker jobseeker = this.jobseekerDao.getById(id);
		if (jobseeker == null) {
			return new ErrorDataResult<Jobseeker>(Messages.notFound);
		}
		return new SuccessDataResult<Jobseeker>(jobseeker);
	}

}
