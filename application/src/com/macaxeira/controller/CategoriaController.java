package com.macaxeira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macaxeira.dao.RepositorioCategoria;
import com.macaxeira.model.Categoria;

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
		return c.getId()+"";
	}

	@RequestMapping("/read")
	public @ResponseBody String read(){
		return "read";
	}
	
	@RequestMapping("/update")
	public @ResponseBody String update(){
		return "update";
	}
	
	@RequestMapping("/delete")
	public @ResponseBody String delete(){
		return "delete";
	}


}
