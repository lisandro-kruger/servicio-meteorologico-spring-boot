package com.api.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.api.domain.Pronostico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class PronosticoRequest {

	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "La fecha solo puede ser futura")
	private LocalDate fecha;

	@PositiveOrZero(message = "Probabilidad de lluvia debe estar entre 0% a 100%")
	@Max(value = 100, message = "Probabilidad de lluvia debe estar entre 0% a 100%")
	private int probabilidad;

	@PositiveOrZero(message = "Cantidad de lluvia en mm debe ser 0 o superior")
	private int cantidad;

	@Size(min = 2, max = 250)
	private String descripcion;

	@NotNull
	private String ciudad;

	public PronosticoRequest() {
		super();
	}

	public PronosticoRequest(LocalDate fecha, int probabilidad, int cantidad, String descripcion, String ciudad) {
		super();
		this.fecha = fecha;
		this.probabilidad = probabilidad;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.ciudad = ciudad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Pronostico toModel() {

		Pronostico newPronostico = new Pronostico();
		newPronostico.setFecha(this.getFecha());
		newPronostico.setProbabilidad(this.getProbabilidad());
		newPronostico.setCantidad(this.getCantidad());
		newPronostico.setDescripcion(this.getDescripcion());
		return newPronostico;
	}

}
