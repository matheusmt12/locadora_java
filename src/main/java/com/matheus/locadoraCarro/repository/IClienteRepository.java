package com.matheus.locadoraCarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.locadoraCarro.entity.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
