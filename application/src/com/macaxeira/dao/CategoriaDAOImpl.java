package com.macaxeira.dao;

import org.springframework.stereotype.Repository;

import com.macaxeira.model.Categoria;

@Repository
public class CategoriaDAOImpl extends GenericDAO<Categoria, Integer> implements
		RepositorioCategoria {

}
