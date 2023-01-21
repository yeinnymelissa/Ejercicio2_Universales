package com.ejercicio2.dataBases.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PACIENTEMASCOTA")
public class Pacientemascota {

	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="TIPO")
	private String tipo;
	
	@Column(name="RAZONCONSULTA")
	private String razonconsulta;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="IDVETERINARIO")
	@JsonProperty(access = Access.WRITE_ONLY)
    private Veterinaria veterinaria;

	public Pacientemascota() {
	}
	
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

	public String getRazonconsulta() {
		return razonconsulta;
	}

	public void setRazonconsulta(String razonconsulta) {
		this.razonconsulta = razonconsulta;
	}

	public Veterinaria getVeterinaria() {
		return veterinaria;
	}

	public void setVeterinaria(Veterinaria veterinaria) {
		this.veterinaria = veterinaria;
	}
	
	
}
