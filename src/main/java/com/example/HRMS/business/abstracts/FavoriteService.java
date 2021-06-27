package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Favorite;

public interface FavoriteService {

	DataResult<List<Favorite>> getByUserId(int userId);
	Result add(Favorite favorite);
	Result delete(Favorite favorite);
}
