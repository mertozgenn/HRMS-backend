package com.example.HRMS.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.SystemEmployeeService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.SystemEmployee;

@RestController
@RequestMapping("/api/systemEmployees")
@CrossOrigin
public class SystemEmployeesController {

	private SystemEmployeeService systemEmployeeService;

	@Autowired
	public SystemEmployeesController(SystemEmployeeService systemEmployeeService) {
		this.systemEmployeeService = systemEmployeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SystemEmployee>> getAll(){
		return this.systemEmployeeService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody SystemEmployee systemEmployee) {
		return ResponseEntity.ok(this.systemEmployeeService.add(systemEmployee));
	}
}
