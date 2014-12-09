package com.macaxeira.dao.jpa;

import org.springframework.stereotype.Repository;

import com.macaxeira.dao.interfaces.AtendenteDAO;
import com.macaxeira.model.Atendente;

@Repository
public class AtendenteDaoJPA extends GenericDaoJPA<Atendente, Integer> implements
		AtendenteDAO {

}
