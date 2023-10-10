package com.api.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.domain.Ciudad;
import com.api.domain.Pronostico;

@Repository
public interface PronosticoRepository extends JpaRepository<Pronostico, Long> {

	@Query("SELECT p FROM Pronostico p WHERE p.ciudad = ?1 and p.fecha  BETWEEN ?2 AND ?3")
	List<Pronostico> findByFilter(Long id, Date fechaActual, Date fechaExtendida);

	@Query("SELECT p FROM Pronostico p WHERE p.fecha > ?1")
	List<Pronostico> findByFecha(Date fecha);

	@Query("SELECT p FROM Pronostico p WHERE p.ciudad = ?1 and p.fecha = ?2")
	Pronostico findByCiudadAndFecha(Ciudad ciudad, Date fecha);
}