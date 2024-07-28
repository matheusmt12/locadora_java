package com.matheus.locadoraCarro.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.sym.Name;
import com.matheus.locadoraCarro.dto.MarcaDTO;
import com.matheus.locadoraCarro.dto.MarcaModelosDTO;
import com.matheus.locadoraCarro.dto.ModeloDTO;
import com.matheus.locadoraCarro.entity.Marca;
import com.matheus.locadoraCarro.entity.Modelo;
import com.matheus.locadoraCarro.repository.IMarcaRepository;

import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarcaService {

	
	private final IMarcaRepository marcaRepository;
	
	
	public List<MarcaDTO> findAll(){
		
		return marcaRepository.findAll().stream().map(marca -> getMarca(marca)).collect(Collectors.toList());
				
	}
	
	public MarcaDTO getMarca(Marca marca) {
		
		return MarcaDTO.builder()
				.id(marca.getId())
				.name(marca.getName())
				.modelos(getModelo(marca.getModelos()))
				.build();	
	}
	
	public List<MarcaModelosDTO> getModelo(List<Modelo> modelo) {
		return modelo.stream().map(m -> 
				MarcaModelosDTO.builder()
				.abs(m.isAbs())
				.airBag(m.isAirBag())
				.lugares(m.getLugares())
				.name(m.getName())
				.build()
				).collect(Collectors.toList());
		}
}
