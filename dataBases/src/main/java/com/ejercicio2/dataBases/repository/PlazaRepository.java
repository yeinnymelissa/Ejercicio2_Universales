package com.ejercicio2.dataBases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio2.dataBases.entity.Plaza;

@Repository("plazaRepository")
public interface PlazaRepository extends JpaRepository<Plaza, Integer>{

}
