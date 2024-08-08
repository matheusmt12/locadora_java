package com.matheus.locadoraCarro.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	@Bean
	public SecurityFilterChain config (HttpSecurity http) throws Exception{
		
	      http
	        .cors(cors->cors.disable())
	        .csrf(csrf->csrf.disable())
	        .authorizeHttpRequests(request -> request
	                .requestMatchers("/marca").permitAll()
	                .requestMatchers("/modelo").permitAll()
	                .requestMatchers("/login").permitAll()
	                .requestMatchers("/sing-up").permitAll()
	                .anyRequest().authenticated())

	        .sessionManagement((session)-> session
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	      return http.build();
	}
	
}
