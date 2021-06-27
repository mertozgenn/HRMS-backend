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

import com.example.HRMS.business.abstracts.FavoriteService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Favorite;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoritesController {

	private FavoriteService favoriteService;
	
	@Autowired
	FavoritesController(FavoriteService favoriteService){
		this.favoriteService = favoriteService;
	}
	
	@GetMapping("/getByUserId")
	public DataResult<List<Favorite>> getByUserId(@RequestParam int userId){
		return this.favoriteService.getByUserId(userId);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Favorite favorite) {
		return this.favoriteService.delete(favorite);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Favorite favorite) {
		return this.favoriteService.add(favorite);
	}
}
