package com.ejercicio2.dataBases.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio2.dataBases.entity.Pasteles;

@Repository("pastelesRepository")
public interface PastelesRepository extends JpaRepository<Pasteles, Serializable>{

}
