package com.ejercicio2.dataBases.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="APLICACIONPLAZA")
public class Aplicacionplaza {
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="APELLIDO")
	private String apellido;
	
	@Column(name="EDAD")
	private Integer edad;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "IDPLAZA")
	private Plaza plaza;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Plaza getPlaza() {
		return plaza;
	}

	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
	}
	
	
}
