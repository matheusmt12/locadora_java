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
public class UserDTO {

	

	private long id;
	@NotBlank(message = "campo obrigatorio")
	private String password;
	@NotBlank(message = "campo obrigatorio")
	private String username;
	
}
