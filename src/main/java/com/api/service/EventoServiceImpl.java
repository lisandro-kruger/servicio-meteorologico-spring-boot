package com.api.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.Excepcion.Excepcion;
import com.api.dao.EventoRepository;
import com.api.domain.Evento;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository repositorio;

	@Override
	public List<Evento> listarEventos() {
		return repositorio.findAll();
	}

	@Override
	public Evento obtenerEventoId(Long id) throws Exception {

		Evento obtenerEvento = this.repositorio.findById(id).get();

		if (obtenerEvento == null) {
			throw new Exception("No se pudo obtener el Evento");
		}

		return obtenerEvento;
	}

	@Override
	public Evento guardarEvento(Evento evento) throws Excepcion {
		
		Evento newEvento = new Evento();
		
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, -1);

		Calendar hoy = Calendar.getInstance();
		hoy.add(Calendar.DATE, 1);

		Date mañana = hoy.getTime();
		Date todayDate = today.getTime();

		// VALIDAMOS QUE LA FECHA NO SEA MAYOR A MAÑANA
		if (evento.getFecha().after(mañana) || evento.getFecha().before(todayDate)) {
			throw new Excepcion("La Fecha debe ser del Día de la Fecha o el Siguiente.");
		} else {
			newEvento = this.repositorio.save(evento);
		}
		
		return newEvento;
	}

	@Override
	public void eliminarEvento(Evento evento) {
		repositorio.delete(evento);
	}

	// METODO QUE GENERA UNA LISTA DE EMAILS DE TODAS LAS PERSONAS QUE ESTEN
	// ASOCIADAS A UNA CIUDAD
	@Override
	public List<String> emailPersonas(Long id_ciudad) {
		return repositorio.searchByCiudadQueryNative(id_ciudad);
	}

}
