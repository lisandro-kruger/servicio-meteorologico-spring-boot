package com.api.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.api.domain.Evento;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class EventoRequest {
	
	private Long id;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@FutureOrPresent(message = "La Fecha solo puede ser el Presente o Futuro")
	private Date fecha;
		
	@Size(min=2, max=500, message = "La descripción debe tener entre 2 y 500 caracteres")
	@NotNull
	private String descripcion;
	
	@NotNull
	private String ciudad;

	public EventoRequest() {
		super();
	}

	public EventoRequest(Date fecha, String descripcion, String ciudad) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.ciudad = ciudad;
	}	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public Evento toModel() {
		Evento newEvento = new Evento();
		newEvento.setFecha(this.getFecha());
		newEvento.setDescripcion(this.getDescripcion());
		return newEvento;
	}
	
}
