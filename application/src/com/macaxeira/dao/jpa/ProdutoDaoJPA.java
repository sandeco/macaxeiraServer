package com.macaxeira.dao.jpa;

import org.springframework.stereotype.Repository;

import com.macaxeira.dao.interfaces.ProdutoDAO;
import com.macaxeira.model.Produto;

@Repository
public class ProdutoDaoJPA extends GenericDaoJPA<Produto, Integer> implements ProdutoDAO {

}
