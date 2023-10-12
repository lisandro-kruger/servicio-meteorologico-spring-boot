package com.api.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.domain.Pronostico;

@Repository
public interface PronosticoRepository extends JpaRepository<Pronostico, Long> {

	@Query(value = "SELECT * FROM pronostico p WHERE p.ciudad = ?1 and p.fecha BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Pronostico> findByFilter(Long ciudad_id, LocalDate fechaActual, LocalDate fechaExtendida);

	@Query(value = "SELECT * FROM pronostico p WHERE p.fecha > ?1", nativeQuery = true)
	List<Pronostico> findByFecha(LocalDate fecha);

	@Query(value = "SELECT * FROM pronostico p WHERE p.ciudad = ?1 and p.fecha = ?2", nativeQuery = true)
	Pronostico findByCiudadAndFecha(Long ciudad_id, LocalDate fecha);

	@Query(value = "SELECT p.* FROM pronostico p WHERE DATE(p.fecha) BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 10 DAY) AND p.ciudad = ?1", nativeQuery = true)
	List<Pronostico> searchByCiudadQueryNative(Long ciudad_id);

}