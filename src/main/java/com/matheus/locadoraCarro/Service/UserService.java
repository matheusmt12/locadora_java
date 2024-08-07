package com.matheus.locadoraCarro.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.locadoraCarro.dto.LoginDTO;
import com.matheus.locadoraCarro.entity.User;
import com.matheus.locadoraCarro.repository.IUserRepository;
import com.matheus.locadoraCarro.security.SecurityConfig;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final IUserRepository userRepository;
	
	public User getByUSerName(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Transactional
	public LoginDTO save (User login) {
		User user =  new User();

		user.setPassword(SecurityConfig.passEncoder().encode(login.getPassword()));
		user.setUsername(login.getUsername());
		userRepository.save(user);
		return new LoginDTO(user.getId(),user.getPassword(),user.getUsername());
	}
}
