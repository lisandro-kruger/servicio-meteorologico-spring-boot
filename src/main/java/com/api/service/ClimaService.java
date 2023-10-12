package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.ClimaRepository;
import com.api.domain.Clima;
import com.api.exceptions.BussinessException;

@Service
public class ClimaService {

	@Autowired
	private ClimaRepository climaRepository;

	public List<Clima> listarClimas() {
		return this.climaRepository.findAll();
	}

	public Clima obtenerClimaId(Long id) throws BussinessException {
		Clima obtenerClima = climaRepository.findById(id).get();

		if (obtenerClima == null) {
			throw new BussinessException("No se pudo obtener el Clima.");
		}
		return obtenerClima;
	}

	public Clima guardarClima(Clima clima) throws BussinessException {

		Clima newClima = new Clima();
		Boolean aux = false;
		List<Clima> climas = this.listarClimas();

		for (Clima c : climas) {
			if (c.getFecha().isEqual(clima.getFecha())
					&& c.getCiudad().getNombre().equals(clima.getCiudad().getNombre())) {
				aux = true;
			}
		}

		if (aux == true) {
			throw new BussinessException("El Clima ya existe !");

		} else {
			newClima = this.climaRepository.save(clima);
		}

		return newClima;

	}

	public Clima actualizarClima(Clima clima) {
		return this.climaRepository.save(clima);
	}

	public void eliminarClima(Clima clima) {
		this.climaRepository.delete(clima);
	}

	public List<Clima> obtenerClimaCiudad(Long ciudad_id) {
		return climaRepository.searchByCiudadQueryNative(ciudad_id);
	}

}
