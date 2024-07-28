package com.matheus.locadoraCarro.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocacaoDTO {

	private String nameCliente;
	private String modeloCarro;
	private float valor;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	private LocalDateTime fimPrevisto;
	private int km_inicial;
	private int km_final;
	
}
