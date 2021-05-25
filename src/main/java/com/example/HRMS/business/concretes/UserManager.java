package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.UserService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.ErrorDataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.UserDao;
import com.example.HRMS.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public DataResult<User> getByEmail(String email) {
		User user = this.userDao.findByEmail(email);
		if (user != null) {
			return new SuccessDataResult<User>(user);
		}
		return new ErrorDataResult<User>();
		
	}
	@Override
	public Result update(User user) {
		this.userDao.save(user);
		return new SuccessResult(Messages.updated);
	}
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}
}
