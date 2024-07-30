package com.matheus.locadoraCarro.controller;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.locadoraCarro.repository.TesteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {

	
	private TesteRepository testeRepository;
	
	public TesteController(TesteRepository testeRepository) {
		this.testeRepository = testeRepository;
	}
	
	@GetMapping()
	public ResponseEntity<String> get() {
		this.testeRepository.setN1("Matheus");
		this.testeRepository.setN2("Souza");
		String res = testeRepository.getN1() + testeRepository.getN2();
		return new ResponseEntity<String>(res,HttpStatus.CREATED);
	}
	
}
