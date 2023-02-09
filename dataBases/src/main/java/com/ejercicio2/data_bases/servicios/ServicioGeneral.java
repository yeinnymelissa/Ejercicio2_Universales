package com.ejercicio2.data_bases.servicios;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class ServicioGeneral {
	
	@Autowired
	NamedParameterJdbcTemplate npjt;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> hacerJoinRestaurante(Integer val){
		String query = "SELECT RESTAURANTE.NOMBRE, PLATILLO.ID, PLATILLO.NOMBRE AS NOMBREPLATILLO FROM RESTAURANTE LEFT JOIN PLATILLO ON RESTAURANTE.ID = PLATILLO.IDRESTAURANTE WHERE RESTAURANTE.ID = :val ORDER BY RESTAURANTE.NOMBRE";
		
		SqlParameterSource sps = new MapSqlParameterSource().addValue("val", val);
		
		return npjt.queryForList(query, sps);
	}
	
	public List<Map<String, Object>> compararEstrellas(Integer val, Integer val2){
		String query = "SELECT * FROM RESTAURANTE WHERE ID = COMPARARESTRELLAS(:val, :val2)";
		
		SqlParameterSource sps = new MapSqlParameterSource()
				.addValue("val", val)
				.addValue("val2", val2);
		
		return npjt.queryForList(query, sps);
	}
	
	public void insertarRestaurante(Integer id, String nom, Integer numestre){
		String query = "{call insertarRestaurante(?,?,?)}";
		 jdbcTemplate.update(query, id, nom, numestre);
	}
	
}
