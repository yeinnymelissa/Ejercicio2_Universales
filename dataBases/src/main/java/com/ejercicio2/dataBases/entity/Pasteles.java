package com.ejercicio2.dataBases.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PASTELES")
public class Pasteles implements Serializable{

	private static final long serialVersionUID = 7456281520975444160L;
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="SABORRELLENO")
	private String saborrelleno;
	
	@Column(name="COLOREXTERIOR")
	private String colorexterior;
	
	@Column(name="DISPONIBLE")
	private String disponible;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSaborrelleno() {
		return saborrelleno;
	}

	public void setSaborrelleno(String saborrelleno) {
		this.saborrelleno = saborrelleno;
	}

	public String getColorexterior() {
		return colorexterior;
	}

	public void setColorexterior(String colorexterior) {
		this.colorexterior = colorexterior;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	
	
}
