package com.matheus.locadoraCarro.entity;

import java.util.List;


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
@Table(name = "modelo")
public class Modelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name; 
	
	@Column(name = "num_portas")
	private int numPortas;
	
	@Column(name = "lugares")
	private int lugares;
	
	@Column(name = "air_bag")
	private boolean airBag;
	
	@Column(name = "abs")
	private boolean abs;

	

	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;
	
	@OneToMany(mappedBy = "modelo")
	private List<Carro> carros;
}
