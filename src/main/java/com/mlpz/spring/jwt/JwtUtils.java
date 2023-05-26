package com.mlpz.spring.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
	private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	private static final long EXPIRATION_TIME = 86400000; //24 hours
	public String generateAuthToken(String username) {
		Date now = new Date();
		Date expiration = new Date(now.getTime() + EXPIRATION_TIME);
		
		String token = Jwts.builder()
				.setSubject(username)
				.setIssuedAt(now)
				.setExpiration(expiration)
				.signWith(SECRET_KEY)
				.compact();
		return token;
	}
	
	public String extractUsername(String token) {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(SECRET_KEY)
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
}
