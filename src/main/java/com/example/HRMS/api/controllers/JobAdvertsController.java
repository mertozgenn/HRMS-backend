package com.example.HRMS.api.controllers;

import java.util.HashMap;
import java.util.List;
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

import com.example.HRMS.business.abstracts.JobAdvertService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.ErrorDataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobAdvert;
import com.example.HRMS.entities.dtos.JobAdvertToAddDto;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertsController (JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<JobAdvert> getById(@RequestParam int id){
		return this.jobAdvertService.getById(id);
	}
	
	@GetMapping("/getallActiveAndApproved")
	public DataResult<List<JobAdvert>> getAllByActiveAndApproved(){
		return this.jobAdvertService.getByActiveAndApproved();
	}
	
	@GetMapping("/getallByActiveAndApprovedSortedByDate")
	public DataResult<List<JobAdvert>> getAllByActiveSortedByDate(){
		return this.jobAdvertService.getByActiveAndApprovedSortedByDateDesc();
	}
	
	@GetMapping("/getallByActiveAndApprovedAndEmployer")
	public DataResult<List<JobAdvert>> getAllByActiveAndEmployer( @RequestParam int employerId){
		return this.jobAdvertService.getByActiveAndApprovedAndEmployerId(employerId);
	}
	
	@GetMapping("/getByNotApproved")
	public DataResult<List<JobAdvert>> getByNotApproved(){
		return this.jobAdvertService.getByNotApproved();
	}
	
	@GetMapping("/getByEmployerId")
	public DataResult<List<JobAdvert>> getByEmployerId(@RequestParam int id){
		return this.jobAdvertService.getByEmployerId(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@Valid @RequestBody JobAdvertToAddDto jobAdvert) {
		return ResponseEntity.ok(jobAdvertService.add(jobAdvert));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Result> update(@Valid @RequestBody JobAdvert jobAdvert) {
		return ResponseEntity.ok(jobAdvertService.update(jobAdvert));
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
