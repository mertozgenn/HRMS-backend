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
import com.example.HRMS.dataAccess.abstracts.EmployerToUpdateDao;
import com.example.HRMS.entities.concretes.Employer;
import com.example.HRMS.entities.concretes.EmployerToUpdate;
import com.example.HRMS.entities.dtos.EmployerToRegisterDto;
import com.example.HRMS.entities.dtos.EmployerToUpdateDto;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerToUpdateDao employerToUpdateDao;
	private EmailService emailService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailService emailService, EmployerToUpdateDao employerToUpdateDao) {
		this.employerDao = employerDao;
		this.employerToUpdateDao = employerToUpdateDao;
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
	public Result update(EmployerToUpdate employerToUpdate) {
		Result result = null;
		
		Employer employer = this.employerDao.getById(employerToUpdate.getUserId());
		
		
		if (employer.getCompanyName().equals(employerToUpdate.getNewCompanyName())) {
			employerToUpdate.setNewCompanyName(null);		
		}
		
		if (employer.getEmail().equals(employerToUpdate.getNewEmail())) {
			employerToUpdate.setNewEmail(null);		
		}
		
		if (employer.getPhoneNumber().equals(employerToUpdate.getNewPhoneNumber())) {
			employerToUpdate.setNewPhoneNumber(null);		
		}
		
		if (employer.getWebsite().equals(employerToUpdate.getNewWebsite())) {
			employerToUpdate.setNewWebsite(null);		
		}
		
		if (employerToUpdate.getNewEmail() != null || employerToUpdate.getNewWebsite()!= null) {
			if (employerToUpdate.getNewEmail() == null) {
				result = BusinessRules.run(checkIfEmailExists(employer.getEmail()), 
						checkDomain(employer.getEmail(), employerToUpdate.getNewWebsite()));
			}
			if (employerToUpdate.getNewWebsite() == null) {
				result = BusinessRules.run(checkIfEmailExists(employer.getEmail()), 
						checkDomain(employer.getEmail(), employer.getWebsite()));
			}
		}
		
		if (result != null) {
			return result;
		}
		
		if (!(employerToUpdate.getNewCompanyName() == null && employerToUpdate.getNewEmail() == null && 
				employerToUpdate.getNewPhoneNumber() == null && employerToUpdate.getNewWebsite() == null)) {
			
			this.employerToUpdateDao.save(employerToUpdate);
			return new SuccessResult();
		}
		return new ErrorResult();
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
	
	
	@Override
	public Result confirmUpdate(EmployerToUpdate employerToUpdate) {

		Employer employer = this.employerDao.getById(employerToUpdate.getUserId());
		
		if (employerToUpdate.getNewCompanyName() != null) {
			employer.setCompanyName(employerToUpdate.getNewCompanyName());
		}
		
		if (employerToUpdate.getNewEmail() != null) {
			employer.setEmail(employerToUpdate.getNewEmail());
		}
		
		if (employerToUpdate.getNewPhoneNumber() != null) {
			employer.setPhoneNumber(employerToUpdate.getNewPhoneNumber());
		}
		
		if (employerToUpdate.getNewWebsite() != null) {
			employer.setWebsite(employerToUpdate.getNewWebsite());
		}
		
		this.employerToUpdateDao.delete(employerToUpdate);
		this.employerDao.save(employer);
		return new SuccessResult();
	}
	
	
	@Override
	public DataResult<List<EmployerToUpdateDto>> getAllPendingUpdates() {
		return new SuccessDataResult<List<EmployerToUpdateDto>>(this.employerToUpdateDao.getAllPendingUpdate());
	}
	@Override
	public DataResult<EmployerToUpdate> getPendingUpdatesByUserId(int userId) {
		return new SuccessDataResult<EmployerToUpdate>(this.employerToUpdateDao.getByUserId(userId));
	}

}
