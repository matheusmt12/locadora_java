package com.matheus.locadoraCarro.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matheus.locadoraCarro.dto.LoginDTO;
import com.matheus.locadoraCarro.dto.UserDTO;
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
	public UserDTO save (UserDTO userDto) {
		User user =  new User();

		user.setPassword(SecurityConfig.passwordEncoder().encode(userDto.getPassword()));
		user.setUsername(userDto.getUsername());
		userRepository.save(user);
		return new UserDTO(user.getId(),user.getPassword(),user.getUsername());
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
}
