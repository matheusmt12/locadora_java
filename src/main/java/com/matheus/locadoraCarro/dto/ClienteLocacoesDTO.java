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
public class ClienteLocacoesDTO {

	private long id;
	private String modeloCarro;
	private float valor;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	private int km_inicial;
	private int km_final;
	
}
