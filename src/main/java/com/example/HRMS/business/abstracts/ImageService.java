package com.example.HRMS.business.abstracts;


import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;

public interface ImageService {
	Result add(int userId, byte[] file);
	DataResult<String> getByUserId(int userId);
	Result delete (int id);
}
