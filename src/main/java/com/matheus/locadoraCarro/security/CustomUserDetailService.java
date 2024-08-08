package com.matheus.locadoraCarro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.matheus.locadoraCarro.Service.UserService;
import com.matheus.locadoraCarro.dto.LoginDTO;
import com.matheus.locadoraCarro.entity.User;
import com.matheus.locadoraCarro.exceptions.PasswordNoFoundException;
import com.matheus.locadoraCarro.exceptions.UsernameNoFoundException;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getByUSerName(username);
		if(user == null) {
			throw new UsernameNoFoundException("Usuario não encontrado");
		}
		return new UserPrincipal(user);
	}
	
	public void verifyUserCredentials(LoginDTO loginDto) {
		
		UserDetails user = loadUserByUsername(loginDto.getUsername());
		boolean verify = SecurityConfig.passwordEncoder().matches(loginDto.getPassword(), user.getPassword());
		if(!verify) {
			throw new PasswordNoFoundException("Senha inválida");
		}
		
	}
}
