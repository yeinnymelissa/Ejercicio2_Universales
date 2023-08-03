package com.ejercicio2.data_bases.servicios;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.ejercicio2.data_bases.dto.SalidaFuncionDTO;

import java.sql.Types;
import java.util.Date;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Service
public class ServicioGeneral {
	
	@Autowired
	NamedParameterJdbcTemplate npjt;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate jt;
	
	private static final String RETORNAR = "retorno";
	private static final String TEXTO = "texto";
	private static final String SALIDA = "salida";
	
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
	
	public SalidaFuncionDTO funcionBd(String texto, int numero) {
		SalidaFuncionDTO sfd = new SalidaFuncionDTO();
		SimpleJdbcCall sjc = new SimpleJdbcCall(jt);
		sjc.withCatalogName("paquete")
			.withFunctionName("funcion")
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
					new SqlOutParameter(RETORNAR, Types.DATE)
					,new SqlInOutParameter(TEXTO, Types.VARCHAR)
					,new SqlParameter("numero",Types.NUMERIC)
					,new SqlOutParameter(SALIDA, Types.VARCHAR));
		SqlParameterSource sps = new MapSqlParameterSource()
			.addValue(TEXTO, texto)
			.addValue("numero", numero);
		
		Map<String,Object> out = sjc.execute(sps);
		if(out.containsKey(RETORNAR)) {
			sfd.setFecha((Date)out.get(RETORNAR));
		}
		if(out.containsKey(TEXTO)) {
			sfd.setTexto(out.get(TEXTO).toString());
		}
		if(out.containsKey(SALIDA)) {
			sfd.setSalida(out.get(SALIDA).toString());
		}
		return sfd;
	}
}
