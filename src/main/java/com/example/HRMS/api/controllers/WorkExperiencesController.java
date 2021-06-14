package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.WorkExperienceService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.WorkExperience;
import com.example.HRMS.entities.dtos.WorkExperienceToAddDto;

@RestController
@RequestMapping("/api/workexperiences")
@CrossOrigin
public class WorkExperiencesController {

	private WorkExperienceService workExperienceService;

	@Autowired
	public WorkExperiencesController(WorkExperienceService workExperienceService) {
		this.workExperienceService = workExperienceService;
	}
	
	@GetMapping("/getByUserId")
	public DataResult<List<WorkExperience>> getByUserId(@RequestParam int userId){
		return this.workExperienceService.getByUserId(userId);
	}
	
	@GetMapping("/getByUserIdSortedByQuitYearDesc")
	public DataResult<List<WorkExperience>> getByUserIdSortedByQuitYearDesc(@RequestParam int userId){
		return this.workExperienceService.getByUserIdSortedByQuitYearDesc(userId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkExperienceToAddDto workExperienceToAdd) {
		return this.workExperienceService.add(workExperienceToAdd);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.workExperienceService.delete(id);
	}
	
}
