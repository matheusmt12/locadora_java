package com.matheus.locadoraCarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.locadoraCarro.entity.Modelo;

@Repository
public interface IModeloRepository extends JpaRepository<Modelo, Long> {

}
