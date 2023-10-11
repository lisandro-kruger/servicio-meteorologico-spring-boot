package com.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.domain.EstadoClima;

@Repository
public interface EstadoClimaRepository extends JpaRepository<EstadoClima, Long> {

	@Query(value = "SELECT * FROM estado_clima e where e.descripcion = ?1", nativeQuery = true)
	EstadoClima findByName(String nombre);
}
