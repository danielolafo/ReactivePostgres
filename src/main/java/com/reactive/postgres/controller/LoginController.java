package com.reactive.postgres.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.postgres.service.JwtService;

@RestController
@RequestMapping("/auth")
public class LoginController {
	
	private final JwtService jwtService;
	
	public LoginController(JwtService jwtService) {
		this.jwtService = jwtService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> signin(@RequestBody String username){
		return ResponseEntity.ok(jwtService.generateToken(username));
	}

}
