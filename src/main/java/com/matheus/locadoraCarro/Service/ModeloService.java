package com.matheus.locadoraCarro.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.matheus.locadoraCarro.dto.CarroDTO;
import com.matheus.locadoraCarro.dto.ModeloCarrosDTO;
import com.matheus.locadoraCarro.dto.ModeloDTO;
import com.matheus.locadoraCarro.entity.Carro;
import com.matheus.locadoraCarro.entity.Modelo;
import com.matheus.locadoraCarro.repository.IModeloRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModeloService {

	private final IModeloRepository modeloRepository;
	
	
	public List<ModeloDTO> findAll() {
		return modeloRepository.findAll().stream().map(modelo -> getModelo(modelo)).collect(Collectors.toList());
		
	}
	
	public ModeloDTO getModelo(Modelo modelo) {
		
		return ModeloDTO.builder()
				.id(modelo.getId())
				.name(modelo.getName())
				.airBag(modelo.isAirBag())
				.abs(modelo.isAbs())
				.lugares(modelo.getLugares())
				.numPortas(modelo.getNumPortas())
				.nameMarca(modelo.getMarca().getName())
				.carros(getCarros(modelo.getCarros()))
				.build();
	}
	
	public List<ModeloCarrosDTO> getCarros(List<Carro> carros) {
		
		return carros.stream().map(carro ->
				ModeloCarrosDTO.builder()
				.disponivel(carro.isDisponivel())
				.km(carro.getKm())
				.placa(carro.getPlaca())
				.id(carro.getId())
				.build()
			).collect(Collectors.toList());
	}
	
	
}
