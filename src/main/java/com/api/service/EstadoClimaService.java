package com.api.service;

import java.util.List;

import com.api.domain.EstadoClima;

public interface EstadoClimaService {
	
	List<EstadoClima> listarEstadosClima();
	
	void guardarEstado(EstadoClima estado);
	
}
