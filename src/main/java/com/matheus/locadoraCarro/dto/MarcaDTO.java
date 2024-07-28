package com.matheus.locadoraCarro.dto;

import java.util.List;

import com.matheus.locadoraCarro.entity.Modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcaDTO {

	private long id;
	private String name;
	private List<ModeloDTO> modelos;
}
