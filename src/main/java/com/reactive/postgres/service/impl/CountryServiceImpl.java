package com.reactive.postgres.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.reactive.postgres.dto.CountryDto;
import com.reactive.postgres.repository.CountryRepository;
import com.reactive.postgres.service.CountryService;

import reactor.core.publisher.Flux;

@Service
public class CountryServiceImpl implements CountryService {
	
	private CountryRepository repository;
	
	public CountryServiceImpl(CountryRepository repository) {
		this.repository = repository;
	}

	@Override
	public Flux<CountryDto> getAll() {
		PageRequest pageReq = PageRequest.of(0, 20);
		return this.repository.findAllBy(pageReq).map(cty -> CountryDto.builder()
				.country(cty.getCountry())
				.countryId(cty.getCountryId()).build());
	}

}
