package com.example.JpaPractice.JWT;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private final String SECRET_KEY = "i7EXTU4u52Hu2A8O487o2Fd5N81amICG0B7q9TOHqthty";
    private final long EXPIRATION_TIME = 86400000; // 24 часа

    public String generateToken(String username, String role) {
        try {
            return Jwts.builder()
                    .setSubject(username)
                    .claim("role", role)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate JWT token", e);
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.err.println("JWT token expired: " + e.getMessage());
            return false;
        } catch (MalformedJwtException e) {
            System.err.println("Invalid JWT token: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("JWT validation error: " + e.getMessage());
            return false;
        }
    }

    public String extractUsername(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            throw new RuntimeException("Failed to extract username from JWT", e);
        }
    }

    public String extractRole(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .get("role", String.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to extract role from JWT", e);
        }
    }
}