package com.api.service;

import java.util.List;

import com.api.Excepcion.Excepcion;
import com.api.domain.Clima;

public interface ClimaService {
	
	List<Clima> listarClimas();

	Clima obtenerClimaId(Long id) throws Excepcion;
	
	Clima guardarClima(Clima clima) throws Excepcion;
	
	Clima actualizarClima(Clima clima);
	
	void eliminarClima(Clima clima);
}
