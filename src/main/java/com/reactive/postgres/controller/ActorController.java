package com.reactive.postgres.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.postgres.entity.Actor;
import com.reactive.postgres.service.ActorService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/actor")
public class ActorController {
	
	private ActorService actorService;
	
	public ActorController(ActorService actorService) {
		this.actorService = actorService;
	}

	
	@GetMapping("/all")
	
	public Flux<Actor> findAll() {
		return this.actorService.findAll();
	}
}
