package com.matheus.locadoraCarro.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {


	private long id;
	private String name;
	private boolean isEnabled;
	private List<ClienteLocacoesDTO> locacoes;
}
