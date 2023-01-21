package com.ejercicio2.dataBases.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="VETERINARIA")
public class Veterinaria{
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DOCTORENCARGADO")
	private String doctorencargado;
	
	@Column(name="DIRECCION")
	private String direccion;
	
	@OneToMany(mappedBy="veterinaria", cascade = CascadeType.ALL)
    private Set<Pacientemascota> pacientemascota = new HashSet<>();
	

	public Veterinaria() {
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

	public String getDoctorencargado() {
		return doctorencargado;
	}

	public void setDoctorencargado(String doctorencargado) {
		this.doctorencargado = doctorencargado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<Pacientemascota> getPacientemascota() {
		return pacientemascota;
	}

	public void setPacientemascota(Set<Pacientemascota> pacientemascota) {
		this.pacientemascota = pacientemascota;
		
		for(Pacientemascota pacientemascota2 : pacientemascota) {
			pacientemascota2.setVeterinaria(this);
		}
	}
	
	
}
