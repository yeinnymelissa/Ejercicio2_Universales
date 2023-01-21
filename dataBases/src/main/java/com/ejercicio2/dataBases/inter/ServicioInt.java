package com.ejercicio2.dataBases.inter;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio2.dataBases.entity.Aplicacionplaza;
import com.ejercicio2.dataBases.entity.Pacientemascota;
import com.ejercicio2.dataBases.entity.Pasteles;
import com.ejercicio2.dataBases.entity.Platillo;
import com.ejercicio2.dataBases.entity.Plaza;
import com.ejercicio2.dataBases.entity.Restaurante;
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
	
	@GetMapping("/consultarRestaurantes")
	public List<Restaurante> buscarRestaurante();
	
	@PostMapping("/guardarRestaurante")
	public Restaurante guardarRestaurante(@RequestBody Restaurante restaurante);
	
	@GetMapping("/consultarPlatillos")
	public List<Platillo> buscarPlatillos();
	
	@PostMapping("/guardarPlatillo")
	public Platillo guardarPlatillos(@RequestBody Platillo platillo);
	
	@GetMapping("/consultarPlazas")
	public List<Plaza> buscarPlazas();
	
	@PostMapping("/guardarPlaza")
	public Plaza guardarPlaza(@RequestBody Plaza plaza);
	
	@GetMapping("/consultarAplicacionPlaza")
	public List<Aplicacionplaza> buscarAplicaionPlazas();
	
	@PostMapping("/guardarAplicacionPlaza")
	public Aplicacionplaza guardarAplicacionPlaza(@RequestBody Aplicacionplaza aplicacionplaza);
}
