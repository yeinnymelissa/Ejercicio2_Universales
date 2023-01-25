package com.ejercicio2.dataBases.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PLATILLO")
public class Platillo {

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="TIPO")
	private String tipo;
	
	@Column(name="IDRESTAURANTE")
	private int idrestaurante;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdrestaurante() {
		return idrestaurante;
	}

	public void setIdrestaurante(int idrestaurante) {
		this.idrestaurante = idrestaurante;
	}

	
	
}
