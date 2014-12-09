package com.macaxeira.dao.jpa;

import org.springframework.stereotype.Repository;

import com.macaxeira.dao.interfaces.IngredienteDAO;
import com.macaxeira.model.Ingrediente;

@Repository
public class IngredienteDaoJPA extends GenericDaoJPA<Ingrediente, Integer> implements
		IngredienteDAO {

}
