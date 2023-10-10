package com.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.Excepcion.Excepcion;
import com.api.dao.PronosticoRepository;
import com.api.domain.Ciudad;
import com.api.domain.Pronostico;

@Service
public class PronosticoServiceImpl implements PronosticoService {

	@Autowired
	private PronosticoRepository repositorio;

	@Override
	public List<Pronostico> listarPronosticos() {
		
		return this.repositorio.findAll();
	}

	@Override
	public Pronostico obtenerPronosticoId(Long id) throws Excepcion{
		
		Pronostico obtenerPronostico = this.repositorio.findById(id).get();
		
		if(obtenerPronostico == null) {
			throw new Excepcion("No se pudo obtener el Pronostico");
		}
		return obtenerPronostico;
	}

	@Override
	public Pronostico guardarPronostico(Pronostico pronostico) throws Excepcion {
		
		Pronostico newPronostico = new Pronostico();
		Pronostico pronosticoExiste = this.obtenerPronosticoExiste(pronostico.getCiudad(), pronostico.getFecha());

		if (pronosticoExiste != null) {
			throw new Excepcion ("Pronostico repetido");
		} else {
			System.out.println("Pronostico guardado");
			newPronostico = repositorio.save(pronostico);
		}
		
		return newPronostico;
	}

	@Override
	public Pronostico actualizarPronostico(Pronostico pronostico) {
		return this.repositorio.save(pronostico);
	}

	@Override
	public void eliminarPronostico(Pronostico pronostico) {
		repositorio.delete(pronostico);
	}

	/*
	 * @Override public List<Pronostico> filter(PronosticoBuscarForm
	 * pronosticoBuscarForm) { return
	 * repositorio.findByFilter(pronosticoBuscarForm.getId(),pronosticoBuscarForm.
	 * getFechaActual(),pronosticoBuscarForm.getFechaExtendida()); }
	 */

	@Override
	public List<Pronostico> listarPronosticosFecha(Date fecha) {
		return repositorio.findByFecha(fecha);
	}

	@Override
	public Pronostico obtenerPronosticoExiste(Ciudad ciudad, Date fecha) {

		return repositorio.findByCiudadAndFecha(ciudad, fecha);
	}

}
