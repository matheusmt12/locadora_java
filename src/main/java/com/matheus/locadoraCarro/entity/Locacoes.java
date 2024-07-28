package com.matheus.locadoraCarro.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "locacoes")
public class Locacoes {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "data_inicio_periodo")
	private LocalDateTime data_inicio_periodo;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "data_fim_periodo")
	private LocalDateTime data_fim_periodo;
	
	@Column(name = "data_fim_periodo_previsto")
	private LocalDateTime fim_previsto;
	
	@Column(name = "valor")
	private float valor;
	
	@Column(name = "km_inicial")
	private int km_inicial;
	
	@Column(name = "km_final")
	private int km_final;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente" , nullable = false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_carro", nullable = false)
	private Carro carro;
	
	
	
}
