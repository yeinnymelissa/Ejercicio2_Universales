package com.ejercicio2.dataBases.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="RESTAURANTE")
public class Restaurante {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="NUMESTRELLAS")
	private Integer numestrellas;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDRESTAURANTE")
    private List<Platillo> platillo;

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

	public Integer getNumestrellas() {
		return numestrellas;
	}

	public void setNumestrellas(Integer numestrellas) {
		this.numestrellas = numestrellas;
	}

	public List<Platillo> getPlatillo() {
		return platillo;
	}

	public void setPlatillo(List<Platillo> platillo) {
		this.platillo = platillo;
	}
	
	
}
