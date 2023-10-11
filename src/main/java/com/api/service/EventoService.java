package com.api.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.EventoRepository;
import com.api.domain.Evento;
import com.api.exceptions.BussinessException;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repositorio;

	public List<Evento> listarEventos() {
		return repositorio.findAll();
	}

	public Evento obtenerEventoId(Long id) throws BussinessException {

		Evento obtenerEvento = this.repositorio.findById(id).get();

		if (obtenerEvento == null) {
			throw new BussinessException("No se pudo obtener el Evento.");
		}

		return obtenerEvento;
	}

	public Evento guardarEvento(Evento evento) throws BussinessException {

		Evento newEvento = new Evento();

		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, -1);

		Calendar hoy = Calendar.getInstance();
		hoy.add(Calendar.DATE, 1);

		// Obtenemos la fecha actual
		LocalDate actual = LocalDate.now();

		// Obtenemos la fecha de mañana
		LocalDate maniana = LocalDate.now().plusDays(1);

		// Validamos que la fecha no sea mayor a mañana ni menor a hoy
		if (evento.getFecha().isAfter(maniana) || evento.getFecha().isBefore(actual)) {
			throw new BussinessException("La Fecha debe ser del Día de la Fecha o el Siguiente.");
		} else {
			newEvento = this.repositorio.save(evento);
		}

		return newEvento;
	}

	public void eliminarEvento(Evento evento) {
		repositorio.delete(evento);
	}

	// METODO QUE GENERA UNA LISTA DE EMAILS DE TODAS LAS PERSONAS QUE ESTEN
	// ASOCIADAS A UNA CIUDAD
	public List<Object[]> suscriptores(Long id_ciudad) {
		return repositorio.searchByCiudadQueryNative(id_ciudad);
	}

}
