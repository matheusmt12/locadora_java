package com.matheus.locadoraCarro.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.locadoraCarro.Service.LocacoesService;
import com.matheus.locadoraCarro.dto.LocacaoDTO;
import com.matheus.locadoraCarro.dto.ResponseDTO;
import com.matheus.locadoraCarro.entity.Locacoes;
import com.matheus.locadoraCarro.exceptions.CarroIndisponivelException;
import com.matheus.locadoraCarro.exceptions.NoCarroExeption;
import com.matheus.locadoraCarro.exceptions.NoClienteException;
import com.matheus.locadoraCarro.repository.ICarroRepository;
import com.matheus.locadoraCarro.repository.IClienteRepository;
import com.matheus.locadoraCarro.repository.ILocacoesRepository;

@RestController
@RequestMapping("/locacoes")
public class LocacoesController {

	private ILocacoesRepository locacaoRepository;

	private ICarroRepository carroRepository;

	private IClienteRepository clienteRepository;
	
	private LocacoesService locacaoService;

	
	@Autowired
	public LocacoesController(ILocacoesRepository locacaoRepository, ICarroRepository carroRepository,
			IClienteRepository clienteRepository , LocacoesService locacoesService) {
		this.locacaoRepository = locacaoRepository;
		this.carroRepository = carroRepository;
		this.clienteRepository = clienteRepository;
		this.locacaoService = locacoesService;
	}

	@GetMapping
	public ResponseEntity get() {
		try {
			ResponseDTO<List<LocacaoDTO>> response = new ResponseDTO<List<LocacaoDTO>>("Sucesso", locacaoService.findAll());
			return new ResponseEntity<>(response,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity post(@RequestBody Locacoes locacao) {
		 long id = locacaoService.save(locacao);
		 ResponseDTO response = new ResponseDTO<>("sucesso", id);
		 locacao.setData_inicio_periodo(LocalDateTime.now());
		 return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
