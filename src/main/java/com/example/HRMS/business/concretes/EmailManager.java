package com.example.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.EmailService;
import com.example.HRMS.business.abstracts.UserService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.entities.User;
import com.example.HRMS.core.utilities.results.ErrorResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService {
	
	private UserService userService;
	
	@Autowired
	public EmailManager(UserService userService) {
		this.userService = userService;
	}

	@Override
	public Result sendVerificationEmail(String email) {
		return new SuccessResult(Messages.verificationEmail);
		
	}
	
	public Result verify(String email) {
		User userToUpdate = (User)this.userService.getByEmail(email).getData();
		userToUpdate.setEmailVerified(true);
		if (this.userService.update(userToUpdate).isSuccess()) {
			return new SuccessResult(Messages.emailVerified + email);
		}
		return new ErrorResult(Messages.error);
	}

}
