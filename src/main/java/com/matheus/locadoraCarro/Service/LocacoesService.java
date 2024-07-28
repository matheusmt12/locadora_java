package com.matheus.locadoraCarro.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.matheus.locadoraCarro.dto.LocacaoDTO;
import com.matheus.locadoraCarro.entity.Locacoes;
import com.matheus.locadoraCarro.repository.ILocacoesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacoesService {

	
	private final ILocacoesRepository locacaoRepository;
	
	public List<LocacaoDTO> findAll() {
		return locacaoRepository.findAll().stream().map(locacao -> getLocacao(locacao)).collect(Collectors.toList());
	}
	
	public LocacaoDTO getLocacao(Locacoes locacao) {
		
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
