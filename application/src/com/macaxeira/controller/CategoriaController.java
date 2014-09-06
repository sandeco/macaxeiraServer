package com.macaxeira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public @ResponseBody String read(@RequestParam String categoria){
		
		
		
		String json = "{ \"id\" : 16, \"nome\" : \"Teste autowired\", \"produtos\" : null }";
		
		Categoria c = (Categoria) JsonProcessor.jsonToEntity(json, Categoria.class);
		
		
		return c.getNome();
	}



	@RequestMapping("/update")
	public @ResponseBody String update(){
		return "update";
	}



	@RequestMapping("/delete")
	public @ResponseBody String delete(){
		return "delete";
	}

	
	/*
	public @ResponseBody Map<String,? extends Object> atualizarAtendimento(@RequestParam Object atendimentoJson){
    	JSONObject jsonObject = JSONPObject.fromObject(atendimentoJson);
		Atendimento a = (Atendimento) JSONObject.toBean(jsonObject, Atendimento.class);
		
		this.atendimentoService.altualizarAtendimento(a);
		
		return getMapObject(a, "atendimento");
	}*/

	

}
