package com.reactive.postgres.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.reactive.postgres.dto.CityDto;
import com.reactive.postgres.repository.CityRepository;
import com.reactive.postgres.service.CityService;

import reactor.core.publisher.Flux;

@Service
public class CityServiceImpl implements CityService {
	
	private final CityRepository cityRepository;
	
	public CityServiceImpl(CityRepository cityRepository){
		this.cityRepository = cityRepository;
	}

	@Override
	public Flux<CityDto> getAll() {
//		return  this.cityRepository.findAll().map(city -> CityMapper.INSTANCE.toDto(city));
		PageRequest pageRequest = PageRequest.of(0, 20);
		return  this.cityRepository.findAllBy(pageRequest).map(city -> CityDto.builder().city(city.getCity()).lastUpdate(city.getLastUpdate()).build());
	}



}
