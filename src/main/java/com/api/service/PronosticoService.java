package com.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.PronosticoRepository;
import com.api.domain.Pronostico;
import com.api.exceptions.BussinessException;

@Service
public class PronosticoService {

	@Autowired
	private PronosticoRepository pronosticoRepository;

	public List<Pronostico> listarPronosticos() {
		return this.pronosticoRepository.findAll();
	}

	public Pronostico obtenerPronosticoId(Long id) throws BussinessException {

		Pronostico obtenerPronostico = this.pronosticoRepository.findById(id).get();

		if (obtenerPronostico == null) {
			throw new BussinessException("No se pudo obtener el Pronostico.");
		}
		return obtenerPronostico;
	}

	public Pronostico guardarPronostico(Pronostico pronostico) throws BussinessException {

		Pronostico newPronostico = new Pronostico();
		Pronostico pronosticoExiste = this.obtenerPronosticoExiste(pronostico.getCiudad().getId(),
				pronostico.getFecha());

		if (pronosticoExiste != null) {
			throw new BussinessException("Pronostico repetido.");
		} else {
			newPronostico = pronosticoRepository.save(pronostico);
		}

		return newPronostico;
	}

	public Pronostico actualizarPronostico(Pronostico pronostico) {
		return this.pronosticoRepository.save(pronostico);
	}

	public void eliminarPronostico(Pronostico pronostico) {
		pronosticoRepository.delete(pronostico);
	}

	/*
	 * @Override public List<Pronostico> filter(PronosticoBuscarForm
	 * pronosticoBuscarForm) { return
	 * repositorio.findByFilter(pronosticoBuscarForm.getId(),pronosticoBuscarForm.
	 * getFechaActual(),pronosticoBuscarForm.getFechaExtendida()); }
	 */
	public List<Pronostico> listarPronosticosFecha(LocalDate fecha) {
		return pronosticoRepository.findByFecha(fecha);
	}

	public Pronostico obtenerPronosticoExiste(Long ciudad_id, LocalDate fecha) {
		return pronosticoRepository.findByCiudadAndFecha(ciudad_id, fecha);
	}

	public List<Object[]> obtenerClimaCiudad(Long ciudad_id) {
		return this.pronosticoRepository.searchByCiudadQueryNative(ciudad_id);
	}

}
