package com.api.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.api.domain.Clima;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ClimaRequest {

	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	@PositiveOrZero(message = "Humedad debe estar entre 0% a 100%")
	@Max(value = 100, message = "Humedad debe estar entre 0% a 100%")
	private int humedad;

	@PositiveOrZero(message = "Temperatura debe estar entre 0° a 60°")
	@Max(value = 60, message = "Temperatura debe estar entre 0° a 60°")
	private int temperatura;

	@NotNull
	private String ciudad;

	@NotNull
	private String estado_clima;

	public ClimaRequest() {
		super();
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

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getHumedad() {
		return humedad;
	}

	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado_clima() {
		return estado_clima;
	}

	public void setEstado_clima(String estado_clima) {
		this.estado_clima = estado_clima;
	}

	public Clima toModel() {

		LocalDate fechaActual = LocalDate.now(); // OBTENEMOS LA FECHA ACTUAL

		Clima newClima = new Clima();
		newClima.setFecha(fechaActual);
		newClima.setHumedad(this.humedad);
		newClima.setTemperatura(this.temperatura);

		return newClima;
	}
}
