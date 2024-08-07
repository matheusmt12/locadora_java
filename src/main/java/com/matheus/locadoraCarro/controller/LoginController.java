package com.matheus.locadoraCarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.matheus.locadoraCarro.entity.User;
import com.matheus.locadoraCarro.repository.IUserRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

//	private UserService userService;
//	private IUserRepository repository;
//	
//	
//	@Autowired
//	public LoginController(UserService userService, IUserRepository repository) {
//		this.userService = userService;
//		this.repository = repository;
//	}


	@GetMapping
	public ResponseEntity get() {
		return new ResponseEntity<>("name",HttpStatus.OK);
		
	}

	@PostMapping()
	public ResponseEntity post(@RequestBody LoginDTO login) {
		try {
			
			return new ResponseEntity<>(login,HttpStatus.CREATED);
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
