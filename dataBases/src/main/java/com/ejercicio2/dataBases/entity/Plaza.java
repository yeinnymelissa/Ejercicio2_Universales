package com.ejercicio2.dataBases.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PLAZA")
public class Plaza {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="VACANTES")
	private Integer vacantes;

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

	public Integer getVacantes() {
		return vacantes;
	}

	public void setVacantes(Integer vacantes) {
		this.vacantes = vacantes;
	}
	
	
}
