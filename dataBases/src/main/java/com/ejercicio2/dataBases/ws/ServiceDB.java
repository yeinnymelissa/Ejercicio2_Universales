package com.ejercicio2.dataBases.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ejercicio2.dataBases.entity.Pacientemascota;
import com.ejercicio2.dataBases.entity.Pasteles;
import com.ejercicio2.dataBases.entity.Platillo;
import com.ejercicio2.dataBases.entity.Restaurante;
import com.ejercicio2.dataBases.entity.Veterinaria;
import com.ejercicio2.dataBases.inter.ServicioInt;
import com.ejercicio2.dataBases.repository.PacientemascotaRepository;
import com.ejercicio2.dataBases.repository.PastelesRepository;
import com.ejercicio2.dataBases.repository.PlatilloRepository;
import com.ejercicio2.dataBases.repository.RestauranteRepository;
import com.ejercicio2.dataBases.repository.VeterinariaRepository;

@Component
public class ServiceDB implements ServicioInt{
	
	@Autowired
	PastelesRepository pr;
	
	@Autowired
	VeterinariaRepository vet;
	
	@Autowired
	PacientemascotaRepository pm;
	
	@Autowired
	RestauranteRepository res;
	
	@Autowired
	PlatilloRepository plar;

	@Override
	public List<Pasteles> buscarPasteles() {
		return pr.findAll();
	}

	@Override
	public Pasteles guardarPastel(Pasteles pastel) {
		return pr.save(pastel);
	}

	@Override
	public List<Veterinaria> buscarVeterinarias() {
		return vet.findAll();
	}

	@Override
	public Veterinaria guardarVeterinaria(Veterinaria veterinaria) {
		return vet.save(veterinaria);
	}

	@Override
	public List<Pacientemascota> buscarMascota() {
		return pm.findAll();
	}

	@Override
	public Pacientemascota guardarMascota(Pacientemascota pacientemascota) {
		return pm.save(pacientemascota);
	}

	@Override
	public List<Restaurante> buscarRestaurante() {
		return res.findAll();
	}

	@Override
	public Restaurante guardarRestaurante(Restaurante restaurante) {
		return res.save(restaurante);
	}

	@Override
	public List<Platillo> buscarPlatillos() {
		return plar.findAll();
	}

	@Override
	public Platillo guardarPlatillos(Platillo platillo) {
		return plar.save(platillo);
	}


}
