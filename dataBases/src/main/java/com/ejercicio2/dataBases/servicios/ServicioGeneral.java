package com.ejercicio2.dataBases.servicios;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class ServicioGeneral {
	
	@Autowired
	NamedParameterJdbcTemplate npjt;
	
	public List<Map<String, Object>> hacerJoinRestaurante(Integer val){
		String query = "SELECT RESTAURANTE.NOMBRE, PLATILLO.ID, PLATILLO.NOMBRE AS NOMBREPLATILLO FROM RESTAURANTE LEFT JOIN PLATILLO ON RESTAURANTE.ID = PLATILLO.IDRESTAURANTE WHERE RESTAURANTE.ID = :val ORDER BY RESTAURANTE.NOMBRE";
		
		SqlParameterSource sps = new MapSqlParameterSource().addValue("val", val);
		
		return npjt.queryForList(query, sps);
	}
}
