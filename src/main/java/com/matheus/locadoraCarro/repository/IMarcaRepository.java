package com.matheus.locadoraCarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matheus.locadoraCarro.entity.Marca;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, Long> {

	
	@Query(value = "select * from marca where id = :id",nativeQuery = true)
	Marca getMaircaId(@Param("id") long id );
}
