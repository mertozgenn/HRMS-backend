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

import com.example.HRMS.business.abstracts.JobseekerLanguageService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobseekerLanguage;
import com.example.HRMS.entities.dtos.JobseekerLanguageToAddDto;

@RestController
@RequestMapping("/api/jobseekerlanguages")
@CrossOrigin
public class JobseekerLanguagesController {

	private JobseekerLanguageService jobseekerLanguageService;

	@Autowired
	public JobseekerLanguagesController(JobseekerLanguageService jobseekerLanguageService) {
		this.jobseekerLanguageService = jobseekerLanguageService;
	}
	
	@GetMapping("/getByUserId")
	public DataResult<List<JobseekerLanguage>> getByUserId(@RequestParam int userId){
		return this.jobseekerLanguageService.getByUserId(userId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody JobseekerLanguageToAddDto jobseekerLanguage) {
		return ResponseEntity.ok(this.jobseekerLanguageService.add(jobseekerLanguage));
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.jobseekerLanguageService.delete(id);
	}
}
