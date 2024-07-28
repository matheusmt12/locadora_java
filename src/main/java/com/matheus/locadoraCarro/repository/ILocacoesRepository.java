package com.matheus.locadoraCarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.locadoraCarro.entity.Locacoes;

@Repository
public interface ILocacoesRepository extends JpaRepository<Locacoes, Long>{

}
