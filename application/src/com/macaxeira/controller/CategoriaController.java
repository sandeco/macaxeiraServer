package com.macaxeira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.macaxeira.dao.RepositorioCategoria;
import com.macaxeira.model.Categoria;
import com.macaxeira.util.JsonProcessor;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private RepositorioCategoria categoriaDao;


	@RequestMapping("/create")
	public @ResponseBody String create(){

		Categoria c = new Categoria();
		c.setNome("Teste autowired");

		categoriaDao.create(c);


		return JsonProcessor.entityToJson(c);
	}



	@RequestMapping("/read")
	public @ResponseBody String read(@RequestParam int id){
		
		Categoria categoria = categoriaDao.findById(id);
		
		Gson gson = new Gson();
		String json = gson.toJson(categoria);
		
		return json;
		
		
	}



	@RequestMapping("/update")
	public @ResponseBody String update(){
		String json = "{ \"id\" : 16, \"nome\" : \"Teste autowired\", \"produtos\" : null }";
		
		Gson gson = new Gson();
		Categoria c = gson.fromJson(json, Categoria.class);
		
		return c.getNome();
	}



	@RequestMapping("/delete")
	public @ResponseBody String delete(@RequestParam int id){
		
		Categoria categoria = categoriaDao.findById(id);
		
		String retorno="true";
		
		try {
			categoriaDao.delete(categoria);
		} catch (Exception e) {
			retorno = e.getMessage();
		}	
		
		
		return retorno;
	}

	
	/*
	public @ResponseBody Map<String,? extends Object> atualizarAtendimento(@RequestParam Object atendimentoJson){
    	JSONObject jsonObject = JSONPObject.fromObject(atendimentoJson);
		Atendimento a = (Atendimento) JSONObject.toBean(jsonObject, Atendimento.class);
		
		this.atendimentoService.altualizarAtendimento(a);
		
		return getMapObject(a, "atendimento");
	}*/

	

}
