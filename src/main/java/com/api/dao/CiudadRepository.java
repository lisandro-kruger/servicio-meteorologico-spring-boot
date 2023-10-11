package com.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.domain.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

	@Query(value = "SELECT * FROM ciudad c where c.nombre = ?1", nativeQuery = true)
	Ciudad findByName(String nombre);
}
