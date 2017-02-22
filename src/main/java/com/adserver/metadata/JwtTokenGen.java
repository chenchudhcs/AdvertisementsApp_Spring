package com.adserver.metadata;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenGen {

	String jwt;
	public String jwtTokenGenerator(String emailId,String uuid)
	{
		jwt=Jwts.builder().setSubject(emailId).claim("random id", uuid).signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		
		return jwt;
		
	}
	
	
	
}
