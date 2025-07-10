package com.reactive.postgres.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.postgres.dto.CityDto;
import com.reactive.postgres.service.CityService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/city")
@CrossOrigin("http://localhost:4200")
public class CityController {
	
	private final CityService cityService;
	
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/getAll")
	public Flux<CityDto> getAll(){
		return this.cityService.getAll();
	}

}
