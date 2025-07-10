package com.reactive.postgres.service;

import com.reactive.postgres.dto.CityDto;

import reactor.core.publisher.Flux;

public interface CityService {
	
	public Flux<CityDto> getAll();

}
