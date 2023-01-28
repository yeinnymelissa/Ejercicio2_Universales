package com.ejercicio2.dataBases.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejercicio2.dataBases.entity.Aplicacionplaza;
import com.ejercicio2.dataBases.entity.Pacientemascota;
import com.ejercicio2.dataBases.entity.Pasteles;
import com.ejercicio2.dataBases.entity.Platillo;
import com.ejercicio2.dataBases.entity.Plaza;
import com.ejercicio2.dataBases.entity.Restaurante;
import com.ejercicio2.dataBases.entity.Veterinaria;
import com.ejercicio2.dataBases.inter.ServicioInt;
import com.ejercicio2.dataBases.repository.AplicacionplazaRepository;
import com.ejercicio2.dataBases.repository.PacientemascotaRepository;
import com.ejercicio2.dataBases.repository.PastelesRepository;
import com.ejercicio2.dataBases.repository.PlatilloRepository;
import com.ejercicio2.dataBases.repository.PlazaRepository;
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
	
	@Autowired
	PlazaRepository plaz;
	
	@Autowired
	AplicacionplazaRepository apli;

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

	@Override
	public List<Plaza> buscarPlazas() {
		return plaz.findAll();
	}

	@Override
	public Plaza guardarPlaza(Plaza plaza) {
		return plaz.save(plaza);
	}

	@Override
	public List<Aplicacionplaza> buscarAplicaionPlazas() {
		
		for(Aplicacionplaza aplis : apli.findAll()) {
			if(aplis.getPlaza() == null) {
				apli.delete(aplis);
			}
		}
		return apli.findAll();
	}

	@Override
	public Aplicacionplaza guardarAplicacionPlaza(Aplicacionplaza aplicacionplaza) {
		return apli.save(aplicacionplaza);
	}

	@Override
	public void eliminarPastel(Integer id) {
		pr.deleteById(id);
		
	}

	@Override
	public void eliminarVeterinaria(Integer id) {
		vet.deleteById(id);
		
	}

	@Override
	public void eliminarMascota(Integer id) {
		pm.deleteById(id);
		
	}

	@Override
	public void eliminarRestaurante(Integer id) {
		
		Optional<Restaurante> resDel = res.findById(id);
		
		if(resDel.isPresent()){
			
			List<Platillo> plati = resDel.get().getPlatillo();
			plar.deleteAll(plati);
			
			for(Platillo platillo : plar.findAll()) {
				System.out.println(platillo.getNombre());
			}
			res.delete(resDel.get());
			
		}
		
		
		
		
	}

	@Override
	public void eliminarPlatillos(Integer id) {
		plar.deleteById(id);
		
	}

	@Override
	public void eliminarPlaza(Integer id) {
		Optional <Plaza> plaza =  plaz.findById(id);
		if(plaza.isPresent()) {
			plaz.delete(plaza.get());
		}
		
	}

	@Override
	public void eliminarApli(Integer id) {
		
		Optional <Aplicacionplaza> aplip =  apli.findById(id);
		if(aplip.isPresent()) {
			apli.delete(aplip.get());
		}
		apli.deleteById(id);
		
	}

	@Override
	public List<Pasteles> buscarPastelesEmpiezan(String letra) {
		return pr.findByNombreStartingWithIgnoreCase(letra);
	}
	
	@Override
	public List<Pasteles> buscarOrdenarDesc(String nombre) {
		return pr.findByNombreOrderByIdDesc(nombre);
	}

	@Override
	public List<Pasteles> buscarOrdenarAsc(String nombre) {
		return pr.findByNombreOrderByIdAsc(nombre);
	}

	@Override
	public List<Pasteles> buscarDisponibilidad(String dispo) {
		return pr.findByDisponibleLikeIgnoreCaseOrderByIdAsc(dispo);
	}

	@Override
	public List<Restaurante> buscarEstrellas(Integer num) {
		return res.findByNumestrellasGreaterThanEqualOrderByIdAsc(num);
	}


}
