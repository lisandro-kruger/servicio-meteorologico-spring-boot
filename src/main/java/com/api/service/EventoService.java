package com.api.service;

import java.util.List;

import com.api.Excepcion.Excepcion;
import com.api.domain.Evento;

public interface EventoService {
	
	List<Evento> listarEventos();
	
	Evento obtenerEventoId(Long id) throws Exception;
	
	Evento guardarEvento(Evento evento) throws Excepcion;
	
	void eliminarEvento(Evento evento);

	List<String> emailPersonas(Long id_ciudad);
}
