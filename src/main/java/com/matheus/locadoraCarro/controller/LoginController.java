package com.matheus.locadoraCarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.locadoraCarro.Service.UserService;
import com.matheus.locadoraCarro.dto.LoginDTO;
import com.matheus.locadoraCarro.dto.TokenDTO;
import com.matheus.locadoraCarro.repository.IUserRepository;
import com.matheus.locadoraCarro.security.CustomUserDetailService;
import com.matheus.locadoraCarro.security.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

	private UserService userService;
	private CustomUserDetailService customUser;
	private JwtService jwtService;
	
	
	@Autowired
	public LoginController(UserService userService, JwtService jwtService, CustomUserDetailService customUser) {
		this.userService = userService;
		this.jwtService = jwtService;
		this.customUser = customUser;
	}


	@Value("${security.jwt.expiration}")
	private String expiration;
	@GetMapping
	public ResponseEntity get() {
		return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
		
	}

	@PostMapping()
	public ResponseEntity post(@Valid @RequestBody LoginDTO login) {
		try {
			customUser.verifyUserCredentials(login);
			
			String token = jwtService.generateToken(login.getUsername());
			return new ResponseEntity<>(new TokenDTO(token,expiration),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity put(@PathVariable long id){
		try {
			return new ResponseEntity<>(id,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping
	public ResponseEntity delete(@PathVariable long id){
		try {
			return new ResponseEntity<>(id,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
