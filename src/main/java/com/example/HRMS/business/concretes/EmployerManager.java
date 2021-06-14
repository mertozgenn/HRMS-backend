package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.EmailService;
import com.example.HRMS.business.abstracts.EmployerService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.business.BusinessRules;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.ErrorDataResult;
import com.example.HRMS.core.utilities.results.ErrorResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.EmployerDao;
import com.example.HRMS.entities.concretes.Employer;
import com.example.HRMS.entities.dtos.EmployerToRegisterDto;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailService emailService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailService emailService) {
		this.employerDao = employerDao;
		this.emailService = emailService;
	}
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.dataListed);
	}

	@Override
	public Result add(EmployerToRegisterDto employerToRegisterDto) {
		
		if (!employerToRegisterDto.getPassword().equals(employerToRegisterDto.getPasswordAgain())) {
			return new ErrorResult(Messages.passwordMatchError);
		}
		Employer employer = new Employer(employerToRegisterDto.getEmail(), employerToRegisterDto.getPassword(),
				employerToRegisterDto.getWebsite(), employerToRegisterDto.getPhoneNumber(), employerToRegisterDto.getCompanyName());
		
		employer.setSystemVerified(false);
		
		Result result = BusinessRules.run(checkIfEmailExists(employer.getEmail()), 
				checkDomain(employer.getEmail(), employer.getWebsite()));
		
		if (result != null) {
			return result;
		}
		
		this.employerDao.save(employer);
		this.emailService.sendVerificationEmail(employerToRegisterDto.getEmail());
		return new SuccessResult(Messages.added);
	}
	
	
	private Result checkIfEmailExists(String email) {
		if (this.employerDao.getByEmail(email) != null) {
			return new ErrorResult(Messages.emailExists);
		}
		return new SuccessResult();
	}
	
	private Result checkDomain(String email, String website) {
		String websiteDomain;
		if (website.contains("www")) {
			int domainStartIndex = website.indexOf("www.");
			websiteDomain = website.substring(domainStartIndex + 4);
		} else {
			websiteDomain = website;
		}
		String emailDomain = email.substring(email.indexOf('@') + 1);
		if (websiteDomain.equals(emailDomain)) {
			return new SuccessResult();
		}
		return new ErrorResult(Messages.domainError);
	}
	
	@Override
	public DataResult<Employer> getByEmail(String email) {
		Employer employer = this.employerDao.getByEmail(email);
		if (employer == null) {
			return new ErrorDataResult<Employer>(Messages.notFound);
		}
		return new SuccessDataResult<Employer>(employer);
	}
	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult();
	}
	@Override
	public DataResult<Employer> getById(int id) {
		Employer employer = this.employerDao.getById(id);
		if (employer == null) {
			return new ErrorDataResult<Employer>(Messages.notFound);
		}
		return new SuccessDataResult<Employer>(employer);
	}
	@Override
	public DataResult<List<Employer>> getByNotApproved() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getBySystemVerified(false));
	}
	@Override
	public DataResult<List<Employer>> getByApproved() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getBySystemVerified(true));
	}

}
