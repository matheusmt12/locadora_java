package com.matheus.locadoraCarro.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.matheus.locadoraCarro.dto.CarroDTO;
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
				.name(modelo.getName())
				.airBag(modelo.isAirBag())
				.abs(modelo.isAbs())
				.lugares(modelo.getLugares())
				.numPortas(modelo.getNumPortas())
				.nameMarca(modelo.getMarca().getName())
				.carros(getCarros(modelo.getCarros()))
				.build();
	}
	
	public List<CarroDTO> getCarros(List<Carro> carros) {
		
		return carros.stream().map(carro ->
				CarroDTO.builder()
				.disponivel(carro.isDisponivel())
				.km(carro.getKm())
				.placa(carro.getPlaca())
				.build()
			).collect(Collectors.toList());
	}
	
	
}
