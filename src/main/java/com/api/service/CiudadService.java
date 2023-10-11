package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.CiudadRepository;
import com.api.domain.Ciudad;

@Service
public class CiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;

	public List<Ciudad> listarCiudades() {
		return ciudadRepository.findAll();
	}

	public Ciudad obtenerCiudadId(Long id) {
		return ciudadRepository.findById(id).get();
	}

	public Ciudad guardarCiudad(Ciudad ciudad) {

		Ciudad newCiudad = new Ciudad();
		Boolean aux = false;
		List<Ciudad> ciudades = this.listarCiudades();

		for (Ciudad c : ciudades) {

			if (c.getNombre() == ciudad.getNombre()) {
				aux = true;
			}
		}

		if (aux == false) {
			newCiudad = ciudadRepository.save(ciudad);
		} else {
			System.out.println("La Ciudad ya Existe !");
		}

		return newCiudad;
	}

	public Ciudad obtenerCiudadNombre(String nombre) {
		return ciudadRepository.findByName(nombre);
	}

}
