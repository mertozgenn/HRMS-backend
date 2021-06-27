package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.FavoriteService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.FavoriteDao;
import com.example.HRMS.entities.concretes.Favorite;

@Service
public class FavoriteManager implements FavoriteService {
	
	private FavoriteDao favoriteDao;
	
	@Autowired
	FavoriteManager(FavoriteDao favoriteDao){
		this.favoriteDao = favoriteDao;
	}

	@Override
	public DataResult<List<Favorite>> getByUserId(int userId) {
		return new SuccessDataResult<List<Favorite>>(this.favoriteDao.getByUserId(userId));
	}

	@Override
	public Result add(Favorite favorite) {
		this.favoriteDao.save(favorite);
		return new SuccessResult();
	}

	@Override
	public Result delete(Favorite favorite) {
		this.favoriteDao.delete(favorite);
		return new SuccessResult();
	}

}
