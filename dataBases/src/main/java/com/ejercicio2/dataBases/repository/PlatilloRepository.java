package com.ejercicio2.dataBases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio2.dataBases.entity.Platillo;

@Repository("platilloRepository")
public interface PlatilloRepository extends JpaRepository<Platillo, Integer>{

}
