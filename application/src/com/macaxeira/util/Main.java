package com.macaxeira.util;

import com.macaxeira.dao.CategoriaDAOImpl;
import com.macaxeira.dao.CategoriaRepositorio;
import com.macaxeira.model.Categoria;

public class Main {

	public static void main(String[] args) {
		
		
		Categoria c = new Categoria();
		c.setNome("hummm");
		
		CategoriaRepositorio repCat = new CategoriaDAOImpl();
		
		repCat.create(c);
		
	}

}
