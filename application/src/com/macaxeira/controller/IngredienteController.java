package com.macaxeira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.macaxeira.dao.interfaces.IngredienteDAO;
import com.macaxeira.model.Ingrediente;


@Controller
@RequestMapping("/ingrediente")
public class IngredienteController {
	
	@Autowired
	IngredienteDAO dao;
	
	// Processado Google para Json
	Gson gson = new Gson();
	
	@RequestMapping("/create")
	public @ResponseBody String create(@RequestParam String json){
		
		
		gson = new Gson();		
		Ingrediente i = gson.fromJson(json, Ingrediente.class);
		
		i = dao.create(i);
		
		String jsonReturn = gson.toJson(i);
		
		return jsonReturn;
		
	}

}
