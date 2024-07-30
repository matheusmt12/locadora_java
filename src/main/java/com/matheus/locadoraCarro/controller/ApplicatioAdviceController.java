package com.matheus.locadoraCarro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.matheus.locadoraCarro.dto.ResponseDTO;
import com.matheus.locadoraCarro.exceptions.CarroIndisponivelException;
import com.matheus.locadoraCarro.exceptions.ClienteNoActive;
import com.matheus.locadoraCarro.exceptions.NoCarroExeption;
import com.matheus.locadoraCarro.exceptions.NoClienteException;

@RestControllerAdvice
public class ApplicatioAdviceController {

	
	@ExceptionHandler(CarroIndisponivelException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseDTO handlerCarroIndisponivelException(CarroIndisponivelException ex) {
		String message = ex.getMessage();
		return new ResponseDTO<>(message, null);	
	}
	
	@ExceptionHandler(NoClienteException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseDTO handlerNoClienteException(NoClienteException ex) {
		String message = ex.getMessage();
		return new ResponseDTO<>(message, null);
	}
	
	@ExceptionHandler(NoCarroExeption.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseDTO handlerNoCarroExeption(NoCarroExeption ex) {
		String message = ex.getMessage();
		return new ResponseDTO<>(message, null);
	}
	
	@ExceptionHandler(ClienteNoActive.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseDTO handlerClienteNoActive(ClienteNoActive ex) {
		return new ResponseDTO<>(ex.getMessage(), null);
	}
	
}
