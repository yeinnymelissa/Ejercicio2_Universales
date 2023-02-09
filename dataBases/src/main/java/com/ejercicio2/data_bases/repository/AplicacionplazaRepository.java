package com.ejercicio2.data_bases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio2.data_bases.entity.Aplicacionplaza;

@Repository("aplicacionplazaRepository")
public interface AplicacionplazaRepository extends JpaRepository<Aplicacionplaza, Integer>{

}
