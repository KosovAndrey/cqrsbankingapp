package com.kosovandrey.cqrsbankingapp.web.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class TokenServiceImpl implements TokenService {
    private final SecretKey key;

    public TokenServiceImpl(String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String create(TokenParameters params) {
        Claims claims = Jwts.claims()
                .subject(params.getSubject())
                .add(params.getClaims())
                .add("tokenType", params.getType())
                .build();

        return Jwts.builder()
                .claims(claims)
                .issuedAt(params.getIssuedAt())
                .expiration(params.getExpiredAt())
                .signWith(this.key)
                .compact();
    }

    public boolean isExpired(String token) {
        return this.isExpired(token, new Date());
    }

    public boolean isExpired(String token, Date date) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .verifyWith(this.key)
                    .build()
                    .parseSignedClaims(token);

            return claims.getPayload().getExpiration().before(date);
        } catch (ExpiredJwtException var4) {
            return true;
        }
    }

    public String getSubject(String token) {
        return Jwts.parser()
                .verifyWith(this.key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String getType(String token) {
        return Jwts.parser()
                .verifyWith(this.key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("tokenType", String.class);
    }

}