package com.macaxeira.dao.jpa;

import org.springframework.stereotype.Repository;

import com.macaxeira.dao.interfaces.UsuarioDAO;
import com.macaxeira.model.Usuario;

@Repository
public class UsuarioDaoJPA extends GenericDaoJPA<Usuario, Integer> implements UsuarioDAO {

}
