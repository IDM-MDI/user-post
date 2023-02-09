package com.kameleoon.userpost.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.kameleoon.userpost")
@EnableJpaRepositories(basePackages = "com.kameleoon.userpost")
@EnableJpaAuditing
public class PersistenceConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
