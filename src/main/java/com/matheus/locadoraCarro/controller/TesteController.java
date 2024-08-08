package com.matheus.locadoraCarro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.locadoraCarro.dto.TesteDTO;

@RestController
@RequestMapping("/teste")
public class TesteController {

		
	@PostMapping
	public ResponseEntity post (@RequestBody TesteDTO teste) {
		return new ResponseEntity<>(teste,HttpStatus.OK);
	}
}
