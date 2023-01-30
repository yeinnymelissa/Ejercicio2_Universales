package com.ejercicio2.dataBases.inter;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@DeleteMapping("/eliminarPastel/{id}")
	public void eliminarPastel(@PathVariable("id") Integer id);
	
	@GetMapping("/consultarVeterinarias")
	public List<Veterinaria> buscarVeterinarias();
	
	@PostMapping("/guardarVeterinaria")
	public Veterinaria guardarVeterinaria(@RequestBody Veterinaria veterinaria);
	
	@DeleteMapping("/eliminarVeterinaria/{id}")
	public void eliminarVeterinaria(@PathVariable("id") Integer id);
	
	@GetMapping("/consultarMascota")
	public List<Pacientemascota> buscarMascota();
	
	@PostMapping("/guardarMascota")
	public Pacientemascota guardarMascota(@RequestBody Pacientemascota pacientemascota);
	
	@DeleteMapping("/eliminarMascota/{id}")
	public void eliminarMascota(@PathVariable("id") Integer id);
	
	@GetMapping("/consultarRestaurantes")
	public List<Restaurante> buscarRestaurante();
	
	@PostMapping("/guardarRestaurante")
	public Restaurante guardarRestaurante(@RequestBody Restaurante restaurante);
	
	@DeleteMapping("/eliminarRestaurante/{id}")
	public void eliminarRestaurante(@PathVariable("id") Integer id);
	
	@GetMapping("/consultarPlatillos")
	public List<Platillo> buscarPlatillos();
	
	@PostMapping("/guardarPlatillo")
	public Platillo guardarPlatillos(@RequestBody Platillo platillo);
	
	@DeleteMapping("/eliminarPlatillo/{id}")
	public void eliminarPlatillos(@PathVariable("id") Integer id);
	
	@GetMapping("/consultarPlazas")
	public List<Plaza> buscarPlazas();
	
	@PostMapping("/guardarPlaza")
	public Plaza guardarPlaza(@RequestBody Plaza plaza);
	
	@DeleteMapping("/eliminarPlaza/{id}")
	public void eliminarPlaza(@PathVariable("id") Integer id);
	
	@GetMapping("/consultarAplicacionPlaza")
	public List<Aplicacionplaza> buscarAplicaionPlazas();
	
	@PostMapping("/guardarAplicacionPlaza")
	public Aplicacionplaza guardarAplicacionPlaza(@RequestBody Aplicacionplaza aplicacionplaza);
	
	@DeleteMapping("/eliminarApli/{id}")
	public void eliminarApli(@PathVariable("id") Integer id);
	
	@GetMapping("/pasteles/empiezanPor/{letra}")
	public List<Pasteles> buscarPastelesEmpiezan(@PathVariable("letra") String letra);
	
	@GetMapping("/pasteles/ordenarDesc/{nombre}")
	public List<Pasteles> buscarOrdenarDesc(@PathVariable("nombre") String nombre);
	
	@GetMapping("/pasteles/ordenarAsc/{nombre}")
	public List<Pasteles> buscarOrdenarAsc(@PathVariable("nombre") String nombre);
	
	@GetMapping("/pasteles/disponible/{dispo}")
	public List<Pasteles> buscarDisponibilidad(@PathVariable("dispo") String dispo);
	
	@GetMapping("/restaurantes/estrellasMayoroIgual/{num}")
	public List<Restaurante> buscarEstrellas(@PathVariable("num") Integer num);

	@GetMapping("/restaurantes/buscarPlatillos/{num}")
	public List<Map<String, Object>> hacerJoinRestaurante(@PathVariable("num") Integer num);
	
	@GetMapping("/restaurantes/compararEstrellas/{num}/{num2}")
	public List<Map<String, Object>> compararEstrellasRes(@PathVariable("num") Integer num, @PathVariable("num2") Integer num2);
	
	@PostMapping("/restaurantes/insertar/{id}/{nom}/{estre}")
	public void insertarRestaurante(@PathVariable("id") Integer id, @PathVariable("nom") String nom, @PathVariable("estre") Integer estre);
}
