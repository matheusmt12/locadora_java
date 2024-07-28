package com.matheus.locadoraCarro.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.matheus.locadoraCarro.dto.CarroDTO;
import com.matheus.locadoraCarro.dto.LocacaoDTO;
import com.matheus.locadoraCarro.entity.Carro;
import com.matheus.locadoraCarro.entity.Locacoes;
import com.matheus.locadoraCarro.repository.ICarroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarroService {

	private final ICarroRepository carroRepository;
	
	
	public List<CarroDTO> findAll(){
		
		return carroRepository.findAll().stream().map( carro ->
				getCarro(carro)
				).collect(Collectors.toList());
	}
	
	public CarroDTO getCarro(Carro carro) {
		return CarroDTO.builder()
				.km(carro.getKm())
				.disponivel(carro.isDisponivel())
				.modelo(carro.getModelo().getName().toString())
				.placa(carro.getPlaca())
				.id(carro.getId())
				.locacoes(getLocacoes(carro.getLocaocoes()))
				.build();
	}
	
	public List<LocacaoDTO> getLocacoes(List<Locacoes> locacoes){
		return locacoes.stream().map(locacao -> 
				LocacaoDTO.builder()
				.dataInicio(locacao.getData_inicio_periodo())
				.km_final(locacao.getKm_final())
				.nameCliente(locacao.getCliente().getName())
				.valor(locacao.getValor())
				.build()
			).collect(Collectors.toList());
	}
	
}
