package com.ejercicio2.data_bases.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ejercicio2.data_bases.entity.Restaurante;

@Repository("restauranteRepository")
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{

	public List<Restaurante> findByNumestrellasGreaterThanEqualOrderByIdAsc(Integer nume);
	
	@Query(value = "SELECT * FROM RESTAURANTE WHERE NUMESTRELLAS >= :val ORDER BY ID ASC", 
			countQuery = "SELECT COUNT(ID) FROM RESTAURANTE",
			nativeQuery = true)
	Page<Restaurante> buscarEstrellasPaginado(Pageable pageable, @Param("val") Integer val);
}
