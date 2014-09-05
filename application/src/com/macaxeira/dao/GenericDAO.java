package com.macaxeira.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDAO<T, ID extends Serializable>  implements Repositorio<T, ID> {
	
	
	private Class<T> classePersistente;
	
	
	//CONSTRUTOR DA CLASSE DAO GENERICA
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classePersistente = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	

	@Override
	public T create(T entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T read(T entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T findById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
