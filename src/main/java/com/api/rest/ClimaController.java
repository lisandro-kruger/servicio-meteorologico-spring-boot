package com.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.Excepcion.Excepcion;
import com.api.domain.Clima;
import com.api.request.ClimaRequest;
import com.api.service.ClimaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clima")
public class ClimaController {

	@Autowired
	private ClimaService servicioClima;
	
	@GetMapping("/list")
	public ResponseEntity<List<Clima>> obtenerEventos() {
		List<Clima> climaList = servicioClima.listarClimas();
		return new ResponseEntity<>(climaList, HttpStatus.OK);
	}
	
	// GUARDAR LOS DATOS DEL FORMULARIO DEL CLIMA
	@PostMapping
	public ResponseEntity<Object> guardarClima(@Valid @RequestBody ClimaRequest climaRequest, BindingResult result) throws Exception{
	
		Clima newClima = new Clima();
		
		if (result.hasErrors()) {
			return new ResponseEntity<Object>("¡ERROR!",HttpStatus.BAD_REQUEST);
		}

		try {
			Clima clima = climaRequest.toModel();
			newClima = servicioClima.guardarClima(clima);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(newClima, HttpStatus.CREATED);
	}

	// GUARDAR LOS DATOS EDITADOS DEL CLIMA
	@PutMapping("/{id}")
	public ResponseEntity<Clima> actualizarClima(@PathVariable("id") Long id, @Valid ClimaRequest climaRequest,
			BindingResult result) throws Excepcion {
		Clima newClima = new Clima();
		Clima climaExistente = servicioClima.obtenerClimaId(id);

		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		try {
			climaExistente.setHumedad(climaRequest.getHumedad());
			climaExistente.setTemperatura(climaRequest.getTemperatura());
//			climaExistente.setCiudad(climaRequest.getCiudad());
//			climaExistente.setEstadoClima(climaRequest.getEstadoClima());

			newClima = servicioClima.actualizarClima(climaExistente);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(newClima, HttpStatus.CREATED);
	}

	// ELIMINAR UN CLIMA
	@DeleteMapping("/{id}")
	public ResponseEntity<Clima> eliminarClima(@PathVariable("id") Long id) {
		
		Clima climaExistente = new Clima();
		
		try {
			climaExistente = servicioClima.obtenerClimaId(id);
			servicioClima.eliminarClima(climaExistente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(climaExistente, HttpStatus.CREATED);
	}

}
