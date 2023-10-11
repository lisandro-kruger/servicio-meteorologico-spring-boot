package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.EstadoClimaRepository;
import com.api.domain.EstadoClima;

@Service
public class EstadoClimaService {
	
	@Autowired
	private EstadoClimaRepository repositorio;
	
	public List<EstadoClima> listarEstadosClima() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	public void guardarEstado(EstadoClima estado){
		// TODO Auto-generated method stub
		Boolean aux = false;
		List<EstadoClima> estados = this.listarEstadosClima();

		for (EstadoClima e : estados) {

			if (e.getDescripcion() == estado.getDescripcion()) {
				aux = true;
			}
		}

		if (aux == false) {
			repositorio.save(estado);
		} else {
			System.out.println("La Estado del Clima ya Existe !");
		}
	}

}
