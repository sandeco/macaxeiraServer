package com.macaxeira.dao.jpa;

import org.springframework.stereotype.Repository;

import com.macaxeira.dao.interfaces.PedidoDAO;
import com.macaxeira.model.Pedido;

@Repository
public class PedidoDaoJPA extends GenericDaoJPA<Pedido, Integer> implements PedidoDAO {

}
