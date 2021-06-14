package com.example.HRMS.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.JobseekerCVInfoService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.ErrorDataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobseekerCVInfo;

@RestController
@RequestMapping("/api/jobseekerCVInfo")
@CrossOrigin
public class JobseekerCVInfoController {

	private JobseekerCVInfoService jobseekerCVInfoService;

	@Autowired
	public JobseekerCVInfoController(JobseekerCVInfoService jobseekerCVInfoService) {
		this.jobseekerCVInfoService = jobseekerCVInfoService;
	}
	
	@GetMapping("/getByUserId")
	public DataResult<JobseekerCVInfo> getByUserId(@RequestParam int userId){
		return this.jobseekerCVInfoService.getByUserId(userId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@Valid @RequestBody JobseekerCVInfo jobseekerCVInfo) {
		return ResponseEntity.ok(this.jobseekerCVInfoService.add(jobseekerCVInfo));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, Messages.validationErrors);
		return errors;
	}
}
