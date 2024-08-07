package com.matheus.locadoraCarro.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDTO {

	private long id;
	@NotBlank(message = "campo obrigatorio")
	private String passwor;
	@NotBlank(message = "campo obrigatorio")
	private String usernam;
	
}
