package com.macaxeira.dao.jpa;

import org.springframework.stereotype.Repository;

import com.macaxeira.dao.interfaces.MesaDAO;
import com.macaxeira.model.Mesa;

@Repository
public class MesaDaoJPA extends GenericDaoJPA<Mesa, Integer> implements MesaDAO {

}
