package com.macaxeira.dao.interfaces;

import org.springframework.stereotype.Repository;

import com.macaxeira.model.Produto;

@Repository
public interface ProdutoDAO extends GenericDAO<Produto, Integer> {

}
