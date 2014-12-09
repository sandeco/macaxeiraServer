package com.macaxeira.dao.jpa;

import org.springframework.stereotype.Repository;

import com.macaxeira.dao.interfaces.AdicionalDAO;
import com.macaxeira.model.Adicional;

@Repository
public class AdicionalDaoJPA extends GenericDaoJPA<Adicional, Integer> implements
		AdicionalDAO {

}
