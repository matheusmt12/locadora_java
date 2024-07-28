package com.matheus.locadoraCarro.dto;

import com.matheus.locadoraCarro.entity.Modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

	private long id;
	private String placa;
	private boolean disponivel;
	private int km;
	private String modelo;
	
}
