package com.matheus.locadoraCarro.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.matheus.locadoraCarro.dto.LocacaoDTO;
import com.matheus.locadoraCarro.entity.Carro;
import com.matheus.locadoraCarro.entity.Cliente;
import com.matheus.locadoraCarro.entity.Locacoes;
import com.matheus.locadoraCarro.exceptions.CarroIndisponivelException;
import com.matheus.locadoraCarro.exceptions.ClienteNoActive;
import com.matheus.locadoraCarro.exceptions.NoCarroExeption;
import com.matheus.locadoraCarro.exceptions.NoClienteException;
import com.matheus.locadoraCarro.repository.ICarroRepository;
import com.matheus.locadoraCarro.repository.IClienteRepository;
import com.matheus.locadoraCarro.repository.ILocacoesRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacoesService {

	
	private final ILocacoesRepository locacaoRepository;
	private final ICarroRepository carroRepository;
	private final IClienteRepository clienteRepository;
	
	public List<LocacaoDTO> findAll() {
		return locacaoRepository.findAll().stream().map(locacao -> getLocacao(locacao)).collect(Collectors.toList());
	}
	
	@Transactional
	public long save(Locacoes locacao) {
		Cliente cliente  = clienteRepository.findById(locacao.getCliente().getId()).orElseThrow(() 
				-> new NoClienteException(String.format("O cliente de %s não existe", locacao.getCliente().getId())));
		Carro carro = carroRepository.findById(locacao.getCarro().getId()).orElseThrow(() 
				-> new NoCarroExeption(String.format("O carro de %s não foi encontrado", locacao.getCarro().getId())));

		
		if(!carro.isDisponivel()) {
			throw new CarroIndisponivelException(String.format("O carro (%s) esta indisponivel no momento", carro.getModelo().getName()));
		}
		if(!cliente.isEnabled()) {
			throw new ClienteNoActive(String.format("O cliente não esta ativo ", null));
		}
		carro.setDisponivel(false);
		carroRepository.save(carro);
		locacao.setCarro(carro);
		locacao.setKm_inicial(carro.getKm());
	
		return locacaoRepository.save(locacao).getId();
		
	}
	
	private LocacaoDTO getLocacao(Locacoes locacao) {
		
		return LocacaoDTO.builder()
				.dataFim(locacao.getData_fim_periodo())
				.dataInicio(locacao.getData_inicio_periodo())
				.fimPrevisto(locacao.getFim_previsto())
				.km_final(locacao.getKm_final())
				.km_inicial(locacao.getKm_inicial())
				.modeloCarro(locacao.getCarro().getModelo().getName())
				.nameCliente(locacao.getCliente().getName())
				.valor(locacao.getValor())
				.build();
	}
}
