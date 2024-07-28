package com.matheus.locadoraCarro.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "carro")
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "placa" , length = 50 , nullable = false)
	private String placa;
	
	@Column(name = "disponivel")
	private boolean disponivel;
	
	@Column(name = "km")
	private int km;
	
	@ManyToOne
	@JoinColumn(name = "modelo_id", nullable = false)
	private Modelo modelo;
	
	@OneToMany(mappedBy = "carro")
	private List<Locacoes> locaocoes;
	
}
