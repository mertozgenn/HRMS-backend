package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.JobseekerService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Jobseeker;
import com.example.HRMS.entities.concretes.dtos.JobseekerToRegisterDto;

@RestController
@RequestMapping("/api/jobseekers")
public class JobseekersController {

	private JobseekerService jobseekerService;
	
	@Autowired
	public JobseekersController(JobseekerService jobseekerService) {
		super();
		this.jobseekerService = jobseekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Jobseeker>> getAll() {
		return this.jobseekerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobseekerToRegisterDto jobseekerToRegisterDto) {
		return this.jobseekerService.add(jobseekerToRegisterDto);
	}
}
