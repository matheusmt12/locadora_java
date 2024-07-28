package com.matheus.locadoraCarro.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModeloDTO {

	private String name;
	private int lugares;
	private boolean airBag;
	private boolean abs;
	private int numPortas;
	private String nameMarca;
	private List<CarroDTO> carros;
	
}
