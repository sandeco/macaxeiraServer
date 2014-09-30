package com.macaxeira.dao.interfaces;

import org.springframework.stereotype.Repository;

import com.macaxeira.model.Usuario;

@Repository
public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {

}
