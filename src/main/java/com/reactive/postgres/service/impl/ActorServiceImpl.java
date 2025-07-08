/**
 * @author Daniel Orlando López Ochoa
 */
package com.reactive.postgres.service.impl;

import org.springframework.stereotype.Service;

import com.reactive.postgres.entity.Actor;
import com.reactive.postgres.repository.ActorRepository;
import com.reactive.postgres.service.ActorService;

import reactor.core.publisher.Flux;

/**
 * 
 * @author Daniel Orlando López Ochoa
 */
@Service
public class ActorServiceImpl implements ActorService {
	
	private ActorRepository repository;
	
	public ActorServiceImpl(ActorRepository repository) {
		this.repository = repository;
	}

	@Override
	public Flux<Actor> findAll() {
		return this.repository.findAll();
	}

}
