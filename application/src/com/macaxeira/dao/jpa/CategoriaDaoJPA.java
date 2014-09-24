package com.macaxeira.dao.jpa;

import org.springframework.stereotype.Repository;

import com.macaxeira.dao.interfaces.CategoriaDAO;
import com.macaxeira.model.Categoria;

@Repository
public class CategoriaDaoJPA extends GenericDaoJPA<Categoria, Integer> implements CategoriaDAO {

}
