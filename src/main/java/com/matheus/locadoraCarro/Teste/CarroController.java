package com.matheus.locadoraCarro.Teste;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/carro")
@RestController
public class CarroController {

	
	@GetMapping()
	public String get() {
	return "Carro";
	}
}
