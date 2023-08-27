package com.joaogabriel.dotaApi.config;

import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.ShallowEtagHeaderFilter;


@Configuration
public class SpringBootConfig {
    @Bean
    public Filter filter() {
        return new ShallowEtagHeaderFilter();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
