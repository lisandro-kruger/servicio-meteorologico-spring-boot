package com.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.domain.Pronostico;
import com.api.request.PronosticoRequest;
import com.api.service.CiudadService;
import com.api.service.PronosticoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pronostico")
public class PronosticoController {

	@Autowired
	private PronosticoService pronosticoService;

	@Autowired
	private CiudadService ciudadService;

	@GetMapping("/list")
	public ResponseEntity<List<Pronostico>> obtenerPronostico() {

		List<Pronostico> pronosticoList = pronosticoService.listarPronosticos();
		return new ResponseEntity<>(pronosticoList, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Pronostico> guardarPronostico(@Valid @RequestBody PronosticoRequest pronosticoRequest,
			BindingResult result) throws Exception {

		Pronostico newPronostico = new Pronostico();

		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		try {
			Pronostico pronostico = pronosticoRequest.toModel();

			pronostico.setCiudad(ciudadService.obtenerCiudadNombre(pronosticoRequest.getCiudad()));

			newPronostico = pronosticoService.guardarPronostico(pronostico);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(newPronostico, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pronostico> actualizarPronostico(@PathVariable("id") Long id,
			@Valid @RequestBody PronosticoRequest pronosticoRequest, BindingResult result) throws Exception {
		Pronostico newPronostico = new Pronostico();

		Pronostico pronosticoExistente = pronosticoService.obtenerPronosticoId(id);

		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		try {
			pronosticoExistente.setFecha(pronosticoRequest.getFecha());
			pronosticoExistente.setProbabilidad(pronosticoRequest.getProbabilidad());
			pronosticoExistente.setCantidad(pronosticoRequest.getCantidad());
			pronosticoExistente.setDescripcion(pronosticoRequest.getDescripcion());

			pronosticoExistente.setCiudad(ciudadService.obtenerCiudadNombre(pronosticoRequest.getCiudad()));
			newPronostico = pronosticoService.actualizarPronostico(pronosticoExistente);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(newPronostico, HttpStatus.CREATED);
	}
}
