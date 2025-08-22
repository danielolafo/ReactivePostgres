package com.reactive.postgres.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.reactive.postgres.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl implements JwtService {

	private final String secretKey = "pvkppmldbhjfflqxcvpdymkmhbnxdyxqgezfpdksiwbarfdeblitxmjvdwmgqklpwndgzaxabchhxowvacjpdgcoacnplztbyipstwqgavhegevjmdbiczeeztwoiersrtkkrhwvmsabxbmkejdxhbytdttnchpbsucbfjuylxsfmjjzsumbhijnrxnrafkdgzcglcvacuhegonlzlrrzjhlmwnezrmlbgouezsfukngkyltltobllvpphngjswf"; // Secret for signing JWTs
    private final long expirationMs = 86400000; // Token validity (1 day)

    public String generateToken(String username) {
        return Jwts.builder()
                   .setSubject(username)
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                   .signWith(SignatureAlgorithm.HS256, secretKey)
                   .claim("roles", "ROLE_USER")
                   .compact(); // Creates the token
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token); // Verifies token integrity
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractUsername(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(secretKey)
                            .parseClaimsJws(token)
                            .getBody();
        return claims.getSubject(); // Extracts the username
    }

}
