package com.api.service;

import java.util.Date;
import java.util.List;

import com.api.Excepcion.Excepcion;
import com.api.domain.Ciudad;
import com.api.domain.Pronostico;

public interface PronosticoService {
	
	List<Pronostico> listarPronosticos();
	
	Pronostico obtenerPronosticoId(Long id) throws Excepcion;
	
	Pronostico guardarPronostico(Pronostico pronostico) throws Excepcion;
	
	Pronostico actualizarPronostico(Pronostico pronostico);
	
	void eliminarPronostico(Pronostico pronostico);
	
	//List<Pronostico> filter(PronosticoBuscarForm pronosticoBuscarForm);
	
	List<Pronostico> listarPronosticosFecha(Date fecha);
	
	Pronostico obtenerPronosticoExiste (Ciudad ciudad, Date fecha);

}
