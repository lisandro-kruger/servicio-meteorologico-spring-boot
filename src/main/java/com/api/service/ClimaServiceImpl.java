package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.Excepcion.Excepcion;
import com.api.dao.ClimaRepository;
import com.api.domain.Clima;

@Service
public class ClimaServiceImpl {

	@Autowired
	private ClimaRepository repositorio;

	public List<Clima> listarClimas() {
		return this.repositorio.findAll();
	}

	public Clima obtenerClimaId(Long id) throws Excepcion {
		Clima obtenerClima = repositorio.findById(id).get();

		if (obtenerClima == null) {
			throw new Excepcion("No se pudo obtener el Clima");
		}
		return obtenerClima;
	}

	public Clima guardarClima(Clima clima) throws Excepcion {
		
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
			throw new Excepcion("El Clima ya existe !");

		} else {
			newClima = this.repositorio.save(clima);
		}
		
		return newClima;

	}

	public Clima actualizarClima(Clima clima) {
		return this.repositorio.save(clima);
	}


	public void eliminarClima(Clima clima) {
		this.repositorio.delete(clima);
	}

}
