package com.api.rest;

import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.domain.Evento;
import com.api.request.EventoRequest;
import com.api.service.EventoServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoServiceImpl servicioEvento;

	@GetMapping("/list")
	public ResponseEntity<List<Evento>> obtenerEventos() {

		List<Evento> eventoList = servicioEvento.listarEventos();
		return new ResponseEntity<>(eventoList, HttpStatus.OK);
	}

	@PostMapping("/agregar")
	public ResponseEntity<Evento> guardarEvento(@Valid @RequestBody EventoRequest eventoRequest, BindingResult result) {
		
		Evento newEvento = new Evento();
		
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		try {
			Evento evento = eventoRequest.toModel();
			newEvento = servicioEvento.guardarEvento(evento);
			System.out.println("Se envía alerta por email a las siguienes casillas:");
			System.out.println(servicioEvento.emailPersonas(evento.getCiudad().getId()));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(newEvento, HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Evento> eliminarEvento(@PathVariable Long id, @RequestParam Evento evento) {
		
		Evento eventoExistente = new Evento();
		try {
			eventoExistente = servicioEvento.obtenerEventoId(id);
			servicioEvento.eliminarEvento(eventoExistente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(eventoExistente, HttpStatus.CREATED);
	}

	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
}
