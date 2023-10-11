package com.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.domain.Clima;

@Repository
public interface ClimaRepository extends JpaRepository<Clima, Long> {

	@Query(value = "SELECT c.* FROM clima c WHERE DATE(c.fecha) = CURDATE() AND c.id_ciudad = ?1", nativeQuery = true)
	List<Object[]> searchByCiudadQueryNative(Long id_ciudad);
}
