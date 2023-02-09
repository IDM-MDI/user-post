package com.kameleoon.userpost.config;

import com.kameleoon.userpost.security.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private static final String LOGIN_ENDPOINT = "/api/v1/users";
    private final JwtTokenFilter filter;
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .httpBasic().disable()
                .cors().and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeHttpRequests()
                .requestMatchers(LOGIN_ENDPOINT).permitAll()
                .requestMatchers(HttpMethod.GET).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
