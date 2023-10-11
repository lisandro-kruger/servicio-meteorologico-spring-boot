package com.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.domain.Ciudad;
import com.api.service.CiudadService;
import com.api.service.ClimaService;
import com.api.service.PronosticoService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private CiudadService ciudadService;

	@Autowired
	private ClimaService climaService;

	@Autowired
	private PronosticoService pronosticoService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Object[]>> filtroEstado(@RequestParam(name = "ciudad") String ciudad) throws Exception {

		Ciudad obtenerCiudad = ciudadService.obtenerCiudadNombre(ciudad);

		List<Object[]> listClimaPronosticos = climaService.obtenerClimaCiudad(obtenerCiudad.getId());

		listClimaPronosticos.addAll(pronosticoService.obtenerClimaCiudad(obtenerCiudad.getId()));

		return new ResponseEntity<>(listClimaPronosticos, HttpStatus.OK);
	}

}
