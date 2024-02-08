package com.vgs.rm.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor //faz a mesma coisa que o autowired
public class WebSecurityConfig {

    private final CustomBasicAuthenticationFilter customBasicAuthenticationFilter;
    @Bean
    public static PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((request) -> request
                        //.requestMatchers(HttpMethod.POST, "/user/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .anyRequest().authenticated()
                ).addFilterBefore(customBasicAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
