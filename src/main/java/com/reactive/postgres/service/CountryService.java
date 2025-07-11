package com.reactive.postgres.service;

import com.reactive.postgres.dto.CountryDto;

import reactor.core.publisher.Flux;

public interface CountryService {
	
	public Flux<CountryDto> getAll();

}
