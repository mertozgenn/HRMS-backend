package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.JobAdvertService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobAdvert;
import com.example.HRMS.entities.concretes.dtos.JobAdvertToAddDto;

@RestController
@RequestMapping("/api/jobadverts")
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
	
	@GetMapping("/getallByActive")
	public DataResult<List<JobAdvert>> getAllByActive(@RequestParam boolean active){
		return this.jobAdvertService.getByActive(active);
	}
	
	@GetMapping("/getallByActiveSortedByDate")
	public DataResult<List<JobAdvert>> getAllByActiveSortedByDate(@RequestParam boolean active){
		return this.jobAdvertService.getByActiveSortedByDateDesc(active);
	}
	
	@GetMapping("/getallByActiveAndEmployer")
	public DataResult<List<JobAdvert>> getAllByActiveAndEmployer(@RequestParam boolean active, @RequestParam int employerId){
		return this.jobAdvertService.getByActiveAndEmployerId(active, employerId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertToAddDto jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
}
