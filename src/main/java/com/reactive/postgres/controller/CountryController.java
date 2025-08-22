package com.reactive.postgres.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.postgres.dto.CountryDto;
import com.reactive.postgres.service.CountryService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/country")
//@CrossOrigin("http://localhost:4200")
@CrossOrigin("*")
public class CountryController {
	
	private final CountryService countryService;
	
	public CountryController(CountryService countryService){
		this.countryService = countryService;
	}
	
	@GetMapping("/getAll")
	Flux<CountryDto> getAll(){
		return this.countryService.getAll();
	}

}
