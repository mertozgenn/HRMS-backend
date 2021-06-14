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

import com.example.HRMS.business.abstracts.JobseekerEducationService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobseekerEducation;
import com.example.HRMS.entities.dtos.JobseekerEducationToAddDto;

@RestController
@RequestMapping("/api/jobseekereducations")
@CrossOrigin
public class JobseekerEducationsController {

	private JobseekerEducationService jobseekerEducationService;

	@Autowired
	public JobseekerEducationsController(JobseekerEducationService jobseekerEducationService) {
		this.jobseekerEducationService = jobseekerEducationService;
	}
	
	@GetMapping("/getByUserId")
	public DataResult<List<JobseekerEducation>> getByUserId(@RequestParam int userId){
		return this.jobseekerEducationService.getByUserId(userId);
	}
	
	@GetMapping("/getByUserIdSortedByGraduationYearDesc")
	public DataResult<List<JobseekerEducation>> getByUserIdSortedByGraduationYearDesc(@RequestParam int userId){
		return this.jobseekerEducationService.getByUserIdSortedByGraduationYearDesc(userId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody JobseekerEducationToAddDto jobseekerEducationToAdd) {
		return ResponseEntity.ok(this.jobseekerEducationService.add(jobseekerEducationToAdd));
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.jobseekerEducationService.delete(id);
	}
	
}
