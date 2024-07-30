package com.matheus.locadoraCarro.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
public class TesteRepository {

	private String n1;
	private String n2;
	
	public TesteRepository(String n1, String n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	
	
	
	public String getN1() {
		return n1;
	}



	public void setN1(String n1) {
		this.n1 = n1;
	}



	public String getN2() {
		return n2;
	}



	public void setN2(String n2) {
		this.n2 = n2;
	}



	public String msn() {
		
		return this.n1 + " " + this.n2;
	}
}
