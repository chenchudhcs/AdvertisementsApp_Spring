package com.adserver.metadata;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

@Component
public class UserValidator {
	Map<String,String> cache=new ConcurrentHashMap<String,String>();

	
	public void saveToken(String tokenName,String token)
	{
		cache.put(tokenName, token);
		
		
	}
	
	
	public boolean removeToken(String token)
	{
		if(cache.containsKey(token))
		{
			cache.remove(token);
			return true;
		}else
		{
			return false;
		}
	}
	public String getEmailIdFromToken(String token)
	{
		
		Jws<Claims> jwt = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token);
		return jwt.getBody().getSubject();
		
		
	}
	
	
	
}
