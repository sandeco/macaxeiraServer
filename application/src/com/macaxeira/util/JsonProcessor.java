package com.macaxeira.util;

import java.io.IOException;
import java.io.Serializable;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class JsonProcessor {

	
	public static String entityToJson(Serializable entity){
		String result="";
		
		ObjectMapper mapper = new ObjectMapper();

		// configura a formatacao do json para impressao com identacao
		mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		
		try {
			result = mapper.writeValueAsString(entity);
		} catch (JsonGenerationException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}finally{
			mapper = null;
		}
		
		
		
		
		return "\"" + entity.getClass().getSimpleName() + "\":"+ result;

	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Serializable jsonToEntity(String json, Class classe){
		Serializable entity = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		try {
			entity = mapper.readValue(json, classe);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			mapper = null;
		}
		
		mapper = null;
		return entity;
	}
}
