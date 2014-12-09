package com.macaxeira.dao.jpa;

import org.springframework.stereotype.Repository;

import com.macaxeira.dao.interfaces.AtendimentoDAO;
import com.macaxeira.model.Atendimento;

@Repository
public class AtendimentoDaoJPA extends GenericDaoJPA<Atendimento, Integer> implements
		AtendimentoDAO {

}
