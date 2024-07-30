package com.matheus.locadoraCarro.controller;

import java.util.List;

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

import com.matheus.locadoraCarro.Service.ModeloService;
import com.matheus.locadoraCarro.entity.Modelo;
import com.matheus.locadoraCarro.repository.IMarcaRepository;
import com.matheus.locadoraCarro.repository.IModeloRepository;

@RestController
@RequestMapping("/modelo")
public class ModeloController {
	
	private IModeloRepository modeloRepository;
	private ModeloService modeloService;
	private IMarcaRepository marcaRepository;
	 
	@Autowired
	 public ModeloController( IModeloRepository modeloRepository, ModeloService modeloService, IMarcaRepository marcaRepository) {
		this.modeloRepository = modeloRepository;
		this.modeloService = modeloService;
		this.marcaRepository = marcaRepository;
	}
	
	@GetMapping
	public ResponseEntity get() {
		
		try {
			return new ResponseEntity<>(modeloService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping()
	public ResponseEntity post(@RequestBody Modelo modelo) {
		try {
			return new ResponseEntity<>(modeloRepository.save(modelo),HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity put(@RequestBody Modelo modelo,@PathVariable long id) {
		try {
			
			if(modeloRepository.existsById(id)) {
				modelo.setId(id);
				modeloRepository.save(modelo);
				return new ResponseEntity<>(modelo,HttpStatus.OK);
			}
			return new ResponseEntity<>("Id não encontrado", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("{id}")
	public ResponseEntity delete(long id) {
		try {
			if(modeloRepository.existsById(id)) {
				modeloRepository.deleteById(id);
				return new ResponseEntity<>("Modelo deletado com sucesso", HttpStatus.OK);
			}
			return new ResponseEntity<>("Id não encontrado",HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
