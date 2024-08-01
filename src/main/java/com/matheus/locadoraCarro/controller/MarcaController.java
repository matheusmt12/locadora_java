package com.matheus.locadoraCarro.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.locadoraCarro.Service.MarcaService;
import com.matheus.locadoraCarro.entity.Marca;
import com.matheus.locadoraCarro.repository.IMarcaRepository;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;

@RestController
@RequestMapping("/marca")
public class MarcaController {

	
	private IMarcaRepository marcaRepository;
	private MarcaService marceService;
	
	public MarcaController(@Autowired IMarcaRepository marcaRepository, @Autowired MarcaService marcaService) {
		this.marcaRepository = marcaRepository;
		this.marceService = marcaService;
	}
	
	
	@GetMapping()
	public ResponseEntity get() {
		
		try {
			return new ResponseEntity<>(marceService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity getID(@PathVariable long id) {
		
		try {
			return new ResponseEntity<>(marceService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping
	public ResponseEntity post(@RequestBody Marca marca) {
		try {
			return new ResponseEntity<>(marcaRepository.save(marca),HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity put(@RequestBody Marca marca, @PathVariable long id) {
		try {
			Optional<Marca> up = marcaRepository.findById(id);
			if(up.isPresent()) {
				marca.setId(id);
				marcaRepository.save(marca);
				return new ResponseEntity<>(marca, HttpStatus.OK);
			}
			return new ResponseEntity<>("Id nã encontrado", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable long id) {
		try {
			if(marcaRepository.existsById(id)) {
				marcaRepository.deleteById(id);
				return new ResponseEntity<>("Marca deletada com sucesso", HttpStatus.OK);
			}
			return new ResponseEntity<>("Id não encontrado",HttpStatus.INTERNAL_SERVER_ERROR);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR); 

		}
	}
	

	
	
}
