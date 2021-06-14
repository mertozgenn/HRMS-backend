package com.example.HRMS.business.concretes;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.example.HRMS.business.abstracts.ImageService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.ImageDao;
import com.example.HRMS.entities.concretes.Image;

@Service
public class CloudinaryServiceAdapter implements ImageService {
	
	private ImageDao imageDao;
	
	@Autowired
	public CloudinaryServiceAdapter(ImageDao imageDao) {
		this.imageDao = imageDao;
	}

	private static Cloudinary getCloudinaryClient() {
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dex8fj7po",
				"api_key", "159154564585735",
				"api_secret", "nz155GaZlrYBztB7DzmJfgZNkgY"));
	}

	private String uploadFile(byte[] file) {
		Map<?, ?> cloudinaryUrl = null;
		String fileName = UUID.randomUUID().toString();
		Cloudinary cloudinary = getCloudinaryClient();
		try {
			cloudinaryUrl = cloudinary.uploader().upload(file, 
					ObjectUtils.asMap("public_id", fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(cloudinaryUrl.toString());
		return (String)cloudinaryUrl.get("public_id");
	}

	@Override
	public Result add(int userId, byte[] file) {
		String fileName = null;
		try {
			fileName = uploadFile(file);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		}
		
		Image image = new Image();
		image.setUserId(userId);
		image.setFileName(fileName);
		
		this.imageDao.save(image);
		return new SuccessResult(Messages.added);
	}

	@Override
	public DataResult<String> getByUserId(int userId) {
		return new SuccessDataResult<String>(this.imageDao.getByUserId(userId).getFileName(), Messages.dataListed);
	}

	@Override
	public Result delete(int id) {
		this.imageDao.deleteById(id);
		return new SuccessResult();
	}
}
