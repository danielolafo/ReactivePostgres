package com.reactive.postgres.service;

import com.reactive.postgres.entity.Actor;

import reactor.core.publisher.Flux;

public interface ActorService {

	public Flux<Actor> findAll();
	
}
