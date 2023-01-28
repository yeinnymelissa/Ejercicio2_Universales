package com.ejercicio2.dataBases.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio2.dataBases.entity.Restaurante;

@Repository("restauranteRepository")
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{

	public List<Restaurante> findByNumestrellasGreaterThanEqualOrderByIdAsc(Integer nume);
}
