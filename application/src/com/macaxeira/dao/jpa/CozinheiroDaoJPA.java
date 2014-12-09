package com.macaxeira.dao.jpa;

import org.springframework.stereotype.Repository;

import com.macaxeira.dao.interfaces.CozinheiroDAO;
import com.macaxeira.model.Cozinheiro;

@Repository
public class CozinheiroDaoJPA extends GenericDaoJPA<Cozinheiro, Integer> implements
		CozinheiroDAO {

}
