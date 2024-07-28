package com.matheus.locadoraCarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.locadoraCarro.Service.CarroService;
import com.matheus.locadoraCarro.entity.Carro;
import com.matheus.locadoraCarro.repository.ICarroRepository;

@RestController
@RequestMapping("/carro")
public class CarroController {

	
	private ICarroRepository carroRepository;
	private CarroService carroService;
	
	public CarroController(@Autowired ICarroRepository carroRepository , CarroService carroService) {
		this.carroRepository = carroRepository;
		this.carroService = carroService;
	}
	
	@GetMapping
	public ResponseEntity get() {
		try {
			return new ResponseEntity<>(carroService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity post(@RequestBody Carro carro) {
		try {
			return new ResponseEntity<>(carroRepository.save(carro),HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity put(@PathVariable long id , @RequestBody Carro carro) {
		try {
			
			if(carroRepository.existsById(id)) {
				carro.setId(id);
				carroRepository.save(carro);
				return new ResponseEntity<>(carro, HttpStatus.OK);
			}
			return new ResponseEntity<>("id n encontrado", HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
