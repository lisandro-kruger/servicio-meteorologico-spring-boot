package com.api.service;

import java.util.List;

import com.api.domain.Ciudad;

public interface CiudadService {
	
	List<Ciudad> listarCiudades();

	Ciudad obtenerCiudadId(Long id);
	
	Ciudad guardarCiudad(Ciudad ciudad);
	
}
