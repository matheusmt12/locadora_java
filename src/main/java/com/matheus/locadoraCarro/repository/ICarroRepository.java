package com.matheus.locadoraCarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.locadoraCarro.entity.Carro;

@Repository
public interface ICarroRepository extends JpaRepository<Carro, Long>{

}
