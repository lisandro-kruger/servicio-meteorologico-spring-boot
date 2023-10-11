package com.api.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clima")
public class Clima {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private LocalDate fecha;

	@Column
	private int humedad;

	@Column
	private int temperatura;

	@JoinColumn(name = "ciudad")
	@ManyToOne()
	private Ciudad ciudad;

	@JoinColumn(name = "estado_clima")
	@ManyToOne()
	private EstadoClima estadoClima;

	public Clima() {
		super();
	}

	public Clima(LocalDate fecha, int humedad, int temperatura, Ciudad ciudad, EstadoClima estadoClima) {
		super();
		this.fecha = fecha;
		this.humedad = humedad;
		this.temperatura = temperatura;
		this.ciudad = ciudad;
		this.estadoClima = estadoClima;
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

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public EstadoClima getEstadoClima() {
		return estadoClima;
	}

	public void setEstadoClima(EstadoClima estadoClima) {
		this.estadoClima = estadoClima;
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

}
