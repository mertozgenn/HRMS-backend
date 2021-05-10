package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.PositionService;
import com.example.HRMS.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions")
public class PositionsControllers {

	private PositionService positionService;

	@Autowired
	public PositionsControllers(PositionService positionService) {
		this.positionService = positionService;
	}
	
	@GetMapping("/getall")
	public List<Position> getAll(){
		return this.positionService.getAll();
	}
}
