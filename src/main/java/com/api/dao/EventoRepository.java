package com.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.domain.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
	
	//METDO QUE GENERA UNA LISTA DE EMAILS DE TODAS LAS PERSONAS QUE ESTEN ASOCIADAS A UNA CIUDAD
	@Query(value = "SELECT usu.mail FROM servicio_mn.usuario usu inner join servicio_mn.usuario_suscripcion sus on usu.id = sus.id_usuario where sus.id_ciudad = ?1", nativeQuery = true)
	List<String> searchByCiudadQueryNative(Long id_ciudad);

}
