package com.macaxeira.dao.jpa;

import org.springframework.stereotype.Repository;

import com.macaxeira.dao.interfaces.SituacaoDAO;
import com.macaxeira.model.Situacao;

@Repository
public class SituacaoDaoJPA extends GenericDaoJPA<Situacao, Integer> implements SituacaoDAO {

}
