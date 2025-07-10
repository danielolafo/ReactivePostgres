package com.reactive.postgres.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.reactive.postgres.entity.City;

import reactor.core.publisher.Flux;

@Repository
public interface CityRepository extends R2dbcRepository<City, Integer> {
	
	public Flux<City> findAllBy(Pageable pageable);

}
