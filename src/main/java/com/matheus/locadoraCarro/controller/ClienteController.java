package com.matheus.locadoraCarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.locadoraCarro.Service.ClienteService;
import com.matheus.locadoraCarro.entity.Cliente;
import com.matheus.locadoraCarro.repository.IClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private IClienteRepository clienteRepository;
	private ClienteService clienteService;
	

	@Autowired
	public ClienteController(IClienteRepository clienteRepository, ClienteService clienteService) {
		this.clienteService = clienteService;
		this.clienteRepository = clienteRepository;
	}
	
	
	@GetMapping
	public ResponseEntity get() {
		try {
			return new ResponseEntity<>(clienteService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity post(@RequestBody Cliente cliente) {
		try {
			cliente.setEnabled(true);
			return new ResponseEntity<>(clienteRepository.save(cliente), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
