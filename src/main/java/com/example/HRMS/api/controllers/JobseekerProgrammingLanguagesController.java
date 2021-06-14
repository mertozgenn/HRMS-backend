package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.JobseekerProgrammingLanguageService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobseekerProgrammingLanguage;
import com.example.HRMS.entities.dtos.JobseekerProgrammingLanguageToAddDto;

@RestController
@RequestMapping("/api/jobseekerProgrammingLanguages")
@CrossOrigin
public class JobseekerProgrammingLanguagesController {

	private JobseekerProgrammingLanguageService jobseekerProgrammingLanguageService;

	@Autowired
	public JobseekerProgrammingLanguagesController(
			JobseekerProgrammingLanguageService jobseekerProgrammingLanguageService) {
		this.jobseekerProgrammingLanguageService = jobseekerProgrammingLanguageService;
	}
	
	@GetMapping("/getByUserId")
	public DataResult<List<JobseekerProgrammingLanguage>> getByUserId(@RequestParam int userId){
		return this.jobseekerProgrammingLanguageService.getByUserId(userId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody JobseekerProgrammingLanguageToAddDto jobseekerProgrammingLanguageToAdd){
		return ResponseEntity.ok(this.jobseekerProgrammingLanguageService.add(jobseekerProgrammingLanguageToAdd));
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.jobseekerProgrammingLanguageService.delete(id);
	}
	
}
