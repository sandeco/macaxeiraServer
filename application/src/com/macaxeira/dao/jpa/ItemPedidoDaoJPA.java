package com.macaxeira.dao.jpa;

import org.springframework.stereotype.Repository;

import com.macaxeira.dao.interfaces.ItemPedidoDAO;
import com.macaxeira.model.ItemPedido;

@Repository
public class ItemPedidoDaoJPA extends GenericDaoJPA<ItemPedido, Integer> implements
		ItemPedidoDAO {

}
