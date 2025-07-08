package com.reactive.postgres.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.reactive.postgres.entity.Actor;

import reactor.core.publisher.Flux;

@Repository
public interface ActorRepository extends R2dbcRepository<Actor, Integer> {

	public Flux<Actor> findAll();
	
}
