package com.macaxeira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.macaxeira.dao.interfaces.CategoriaDAO;
import com.macaxeira.model.Categoria;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaDAO categoriaDao;

	// Processado Google para Json
	Gson gson = new Gson();

	
	

	@RequestMapping("/create")
	public @ResponseBody String create(){
		
		Categoria categoria = new Categoria();
		categoria.setNome("Teste autowired");
		categoriaDao.create(categoria);
		
		return gson.toJson(categoria);
		
	}

	
	@RequestMapping("/read")
	public @ResponseBody String read(@RequestParam int id){
		
		Categoria categoria = categoriaDao.findById(id);
		
		return gson.toJson(categoria);
		
	}



	@RequestMapping("/update")
	public @ResponseBody String update(){
		
		Categoria categoria = categoriaDao.findById(5);	
		categoria.setNome("sanderson");
		categoriaDao.update(categoria);
	
		return gson.toJson(categoria);
	}



	@RequestMapping("/delete")
	public @ResponseBody String delete(@RequestParam int id){
		
		String retorno = "true";
		try {
			categoriaDao.delete(id);
		} catch (Exception e) {
			retorno  = "false";
			e.printStackTrace();
		}	
		
		
		return retorno;
	}

	@RequestMapping("/list")
	public @ResponseBody String listAll(){
		
		List<Categoria> categorias;
		categorias = categoriaDao.listAll();
		
		return "{\"categorias\":" + gson.toJson(categorias) + "}";
		
		
	}
	
	

}
