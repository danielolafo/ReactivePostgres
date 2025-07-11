package com.reactive.postgres.service;

public interface JwtService {
	
	public String generateToken(String username);
	
	public boolean validateToken(String token);
	
	public String extractUsername(String token);

}
