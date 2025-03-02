package com.example.demo;

import java.util.Date;
import java.util.Scanner;

import javax.crypto.SecretKey;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@SpringBootApplication
public class JwtTokenGenerationApplication {

	private static SecretKey key = Keys.hmacShaKeyFor("kodnest ultrassecurityfortoken9553756337".getBytes());
	public static void main(String[] args) {
		
		String username = "Srinivas";
		String role ="admin";
		
		String token  = generateToken(username,role);
		System.out.println(token);
		Scanner sc = new Scanner(System.in);
		
		String name =sc.next();
		String role1 = sc.next();
		String t2  = generateToken(name,role1);
		System.out.println(t2);
		
		
		
	}
	
	public static String generateToken(String username, String role) {
		JwtBuilder builder = Jwts.builder();
		builder.claim("role",role);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date(System.currentTimeMillis() + 3600000));
		builder.signWith(key);
		String token  = builder.compact(); 
		return token;
	}

}
