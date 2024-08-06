package com.matheus.locadoraCarro.security;

import org.springframework.context.annotation.Configuration;
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
	
	public PasswordEncoder passEncoder() {
		return new  BCryptPasswordEncoder();
	}

	public SecurityFilterChain config (HttpSecurity http) throws Exception{
		
		http
			.cors(cors -> cors.disable())
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(requeste -> requeste
					.requestMatchers("/login").permitAll()
					.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults())
			.sessionManagement((session) -> session
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
			
			return http.build();
		
		
	}
	
}
