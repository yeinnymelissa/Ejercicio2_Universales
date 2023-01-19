package com.ejercicio2.dataBases.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejercicio2.dataBases.entity.Pasteles;
import com.ejercicio2.dataBases.inter.ServicioInt;
import com.ejercicio2.dataBases.repository.PastelesRepository;

@Component
public class ServiceDB implements ServicioInt{
	
	@Autowired
	PastelesRepository pr;

	@Override
	public List<Pasteles> buscarPasteles() {
		return pr.findAll();
	}

	@Override
	public Pasteles guardarPastel(Pasteles pastel) {
		return pr.save(pastel);
	}

}
