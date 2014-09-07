package com.macaxeira.dao;

import java.io.Serializable;
import java.util.List;

public interface Repositorio<T, ID extends Serializable> {
	
	
	public T create(T entidade);
	public T read(T entidade);
	public T update(T entidade);
	public void delete(T entidade) throws Exception; 
	
	public T findById(ID id);
	public List<T> listAll();
	

}
