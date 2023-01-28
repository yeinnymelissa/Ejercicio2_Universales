package com.ejercicio2.dataBases.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio2.dataBases.entity.Pasteles;

@Repository("pastelesRepository")
public interface PastelesRepository extends JpaRepository<Pasteles, Serializable>{
	public List<Pasteles> findByNombreStartingWithIgnoreCase(String letra);
	public List<Pasteles> findByNombreOrderByIdDesc(String nombre);
	public List<Pasteles> findByNombreOrderByIdAsc(String nombre);
	public List<Pasteles> findByDisponibleLikeIgnoreCaseOrderByIdAsc(String dispo);
	
}
