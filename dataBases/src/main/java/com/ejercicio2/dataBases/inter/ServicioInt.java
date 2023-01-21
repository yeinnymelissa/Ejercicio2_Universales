package com.ejercicio2.dataBases.inter;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio2.dataBases.entity.Pacientemascota;
import com.ejercicio2.dataBases.entity.Pasteles;
import com.ejercicio2.dataBases.entity.Veterinaria;

@RestController
@RequestMapping("/service")
@CrossOrigin
public interface ServicioInt {
	
	@GetMapping("/consultarPasteles")
	public List<Pasteles> buscarPasteles();
	
	@PostMapping("/guardarPastel")
	public Pasteles guardarPastel(@RequestBody Pasteles pastel);
	
	@GetMapping("/consultarVeterinarias")
	public List<Veterinaria> buscarVeterinarias();
	
	@PostMapping("/guardarVeterinaria")
	public Veterinaria guardarVeterinaria(@RequestBody Veterinaria veterinaria);
	
	@GetMapping("/consultarMascota")
	public List<Pacientemascota> buscarMascota();
	
	@PostMapping("/guardarMascota")
	public Pacientemascota guardarMascota(@RequestBody Pacientemascota pacientemascota);
	
	@GetMapping("/obtenerVeterinarias")
	public ResponseEntity<Page<Veterinaria>> listarVeterinarias(Pageable pageable);
}
