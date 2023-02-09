package com.ejercicio2.data_bases.ws;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.ejercicio2.data_bases.entity.Aplicacionplaza;
import com.ejercicio2.data_bases.entity.Pacientemascota;
import com.ejercicio2.data_bases.entity.Pasteles;
import com.ejercicio2.data_bases.entity.Platillo;
import com.ejercicio2.data_bases.entity.Plaza;
import com.ejercicio2.data_bases.entity.Restaurante;
import com.ejercicio2.data_bases.entity.Veterinaria;
import com.ejercicio2.data_bases.inter.ServicioInt;
import com.ejercicio2.data_bases.repository.AplicacionplazaRepository;
import com.ejercicio2.data_bases.repository.PacientemascotaRepository;
import com.ejercicio2.data_bases.repository.PastelesRepository;
import com.ejercicio2.data_bases.repository.PlatilloRepository;
import com.ejercicio2.data_bases.repository.PlazaRepository;
import com.ejercicio2.data_bases.repository.RestauranteRepository;
import com.ejercicio2.data_bases.repository.VeterinariaRepository;
import com.ejercicio2.data_bases.servicios.ServicioGeneral;

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
	
	@Autowired
	ServicioGeneral ser;

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

	@Override
	public List<Map<String, Object>> hacerJoinRestaurante(Integer num) {
		return ser.hacerJoinRestaurante(num);
	}

	@Override
	public List<Map<String, Object>> compararEstrellasRes(Integer num, Integer num2) {
		return ser.compararEstrellas(num, num2);
	}

	@Override
	public void insertarRestaurante(Integer id, String nom, Integer estre) {
		ser.insertarRestaurante(id, nom, estre);
	}

	@Override
	public Page<Pasteles> buscarPastelPag(Integer pag, Integer cant) {
		Pageable paginador = PageRequest.of(pag, cant);
		return pr.findAll(paginador);
	}

	@Override
	public Page<Pasteles> buscarDispoPastelPag(Integer pag, Integer cant) {
		Pageable paginador = PageRequest.of(pag, cant);
		return pr.buscarDisponiblePaginado(paginador);
	}

	@Override
	public Page<Pasteles> buscarEmpiezaPastelPag(String val, Integer pag) {
		Pageable paginador = PageRequest.of(pag, 3);
		return pr.buscarInicioPaginado(paginador, val.toLowerCase());
	}

	@Override
	public Page<Restaurante> verEstrellas(Integer num, Integer pag) {
		Pageable paginador = PageRequest.of(pag, 3);
		return res.buscarEstrellasPaginado(paginador, num);
	}
	

}
