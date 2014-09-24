package com.macaxeira.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class SyncEntitys<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<T> entitys = new ArrayList<T>();
	private Class<T> entity;
	private String token;
	private String dataUpdate;
	
	
	public SyncEntitys(){
		this.entity = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void addEntity(T entity){
		entitys.add(entity);
	}



	public List<T> getEntitys() {
		return entitys;
	}



	public void setEntitys(List<T> entitys) {
		this.entitys = entitys;
	}

	public Class<T> getEntity() {
		return entity;
	}

	public void setEntity(Class<T> entity) {
		this.entity = entity;
	}


}

