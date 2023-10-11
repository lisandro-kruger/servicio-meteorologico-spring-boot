package com.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.domain.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

	// METDO QUE GENERA UNA LISTA DE EMAILS DE TODAS LAS PERSONAS QUE ESTEN
	// ASOCIADAS A UNA CIUDAD
	@Query(value = "SELECT usu.* FROM suscripcion usu INNER JOIN suscripcion_ciudad sus ON usu.id = sus.suscripcion_id WHERE sus.ciudad_id = ?1", nativeQuery = true)
	List<Object[]> searchByCiudadQueryNative(Long id_ciudad);

}
