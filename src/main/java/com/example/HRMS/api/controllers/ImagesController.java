package com.example.HRMS.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.HRMS.business.abstracts.ImageService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.ErrorResult;
import com.example.HRMS.core.utilities.results.Result;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

	private ImageService imageService;

	@Autowired
	public ImagesController(ImageService imageService) {
		this.imageService = imageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int userId, @RequestBody MultipartFile file) {
		try {
			byte[] image = file.getBytes();
			return this.imageService.add(userId, image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorResult(Messages.error);
	}
	
	@GetMapping("/getByUserId")
	public DataResult<String> getByUserId(@RequestParam int userId){
		return this.imageService.getByUserId(userId);
	}
	
}
