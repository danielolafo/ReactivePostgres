package com.reactive.postgres.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.reactive.postgres.entity.Country;

import reactor.core.publisher.Flux;

@Repository
public interface CountryRepository extends R2dbcRepository<Country, Integer> {

	public Flux<Country> findAllBy(Pageable pageable);
	
}
