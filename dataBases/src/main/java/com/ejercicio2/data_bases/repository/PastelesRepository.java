package com.ejercicio2.data_bases.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ejercicio2.data_bases.entity.Pasteles;

@Repository("pastelesRepository")
public interface PastelesRepository extends JpaRepository<Pasteles, Serializable>{
	public List<Pasteles> findByNombreStartingWithIgnoreCase(String letra);
	public List<Pasteles> findByNombreOrderByIdDesc(String nombre);
	public List<Pasteles> findByNombreOrderByIdAsc(String nombre);
	public List<Pasteles> findByDisponibleLikeIgnoreCaseOrderByIdAsc(String dispo);
	
	@Query(value = "SELECT * FROM PASTELES WHERE DISPONIBLE = 'Si' ORDER BY ID ASC", 
			countQuery = "SELECT COUNT(ID) FROM PASTELES",
			nativeQuery = true)
	Page<Pasteles> buscarDisponiblePaginado(Pageable pageable);
	
	@Query(value = "SELECT * FROM PASTELES WHERE LOWER(NOMBRE) LIKE :val%  ORDER BY ID ASC", 
			countQuery = "SELECT COUNT(ID) FROM PASTELES",
			nativeQuery = true)
	Page<Pasteles> buscarInicioPaginado(Pageable pageable, @Param("val") String val);
	
}
