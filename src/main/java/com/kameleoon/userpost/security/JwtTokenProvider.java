package com.kameleoon.userpost.security;

import com.kameleoon.userpost.exception.WebException;
import com.kameleoon.userpost.model.UserDto;
import com.kameleoon.userpost.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

import static com.kameleoon.userpost.exception.ExceptionCode.JWT_TOKEN_IS_EXPIRED;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final UserService userDetailsService;
    @Value("${app.jwt.secret}")
    private String secret;
    @Value("${app.jwt.expiration}")
    private int validity;
    @PostConstruct
    protected void init() {
        this.secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public String createToken(UserDto user) {
        Claims claims = Jwts.claims().setSubject(user.getLogin());

        Date now = new Date();
        Date dateValidity = new Date(now.getTime() + validity);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(dateValidity)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }
    public Authentication getAuthentication(String token) {
        UserDetails user = userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
    }
    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
    @SneakyThrows
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            throw new WebException(JWT_TOKEN_IS_EXPIRED.toString());
        }
    }
}
