package com.matheus.locadoraCarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.locadoraCarro.entity.Marca;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, Long> {

}
