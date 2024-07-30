package com.matheus.locadoraCarro.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.matheus.locadoraCarro.dto.ClienteDTO;
import com.matheus.locadoraCarro.dto.ClienteLocacoesDTO;
import com.matheus.locadoraCarro.dto.LocacaoDTO;
import com.matheus.locadoraCarro.entity.Cliente;
import com.matheus.locadoraCarro.entity.Locacoes;
import com.matheus.locadoraCarro.repository.IClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

	
	private final IClienteRepository clienteRepository;
	
	public List<ClienteDTO> findAll(){
		return clienteRepository.findAll().stream().map(cliente -> getCliente(cliente)).collect(Collectors.toList());
	}
	
	public ClienteDTO getCliente(Cliente cliente) {
		return ClienteDTO.builder()
				.id(cliente.getId())
				.name(cliente.getName())
				.isEnabled(cliente.isEnabled())
				.locacoes(getLocacoes(cliente.getLocacoes()))
				.build();
		
	}
	
	private List<ClienteLocacoesDTO> getLocacoes(List<Locacoes> locacoes){
		return locacoes.stream().map(locacao -> 
			
				ClienteLocacoesDTO.builder()
				.id(locacao.getId())
				.modeloCarro(locacao.getCarro().getModelo().getName())
				.valor(locacao.getValor())
				.dataInicio(locacao.getData_inicio_periodo())
				.km_inicial(locacao.getKm_inicial())
				.build()
				).collect(Collectors.toList());
		
	}
	
	public ClienteDTO getClienteById(long id) {

		Cliente cliente =  clienteRepository.findById(id).get();
		return getCliente(cliente);
	}
	
}
