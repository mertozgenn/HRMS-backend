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

import com.example.HRMS.business.abstracts.EmployerService;
import com.example.HRMS.business.constants.Messages;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.ErrorDataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Employer;
import com.example.HRMS.entities.concretes.EmployerToUpdate;
import com.example.HRMS.entities.dtos.EmployerToRegisterDto;
import com.example.HRMS.entities.dtos.EmployerToUpdateDto;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}
	
	@GetMapping("/getByEmail")
	public DataResult<Employer> getByEmail(@RequestParam String email){
		return this.employerService.getByEmail(email);
	}
	
	@GetMapping("/getById")
	public DataResult<Employer> getById(@RequestParam int id){
		return this.employerService.getById(id);
	}
	
	@GetMapping("/getByNotApproved")
	public DataResult<List<Employer>> getByNotApproved(){
		return this.employerService.getByNotApproved();
	}
	
	@GetMapping("/getByApproved")
	public DataResult<List<Employer>> getByApproved(){
		return this.employerService.getByApproved();
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@Valid @RequestBody EmployerToRegisterDto employerToRegisterDto) {
		return ResponseEntity.ok(this.employerService.add(employerToRegisterDto));
	}
	
	@GetMapping("/getallPendingUpdates")
	public DataResult<List<EmployerToUpdateDto>> getAllPendingUpdates(){
		return this.employerService.getAllPendingUpdates();
	}
	
	@GetMapping("/getPendingUpdatesByUserId")
	public DataResult<EmployerToUpdate> getPendingUpdatesByUserId(@RequestParam int userId){
		return this.employerService.getPendingUpdatesByUserId(userId);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Result> Update(@RequestBody EmployerToUpdate employerToUpdate) {
		return ResponseEntity.ok(this.employerService.update(employerToUpdate));
	}
	
	@PostMapping("/confirmUpdate")
	public ResponseEntity<Result> confirmUpdate(@RequestBody EmployerToUpdate employerToUpdate) {
		return ResponseEntity.ok(this.employerService.confirmUpdate(employerToUpdate));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, Messages.validationErrors);
		return errors;
	}
}
