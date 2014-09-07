package com.macaxeira.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import com.macaxeira.util.JPAUtil;

public class GenericDAO<T, ID extends Serializable>  implements Repositorio<T, ID> {
	
	EntityManager em;
	private Class<T> classePersistente;
	
	
	//CONSTRUTOR DA CLASSE DAO GENERICA
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		em = JPAUtil.getEntityManager();
		this.classePersistente = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	

	@Override
	public T create(T entidade) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
		return entidade;
	}

	@Override
	public T read(T entidade) {
		
		return null;
	}

	@Override
	public T update(T entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T entidade) throws Exception{
		em = JPAUtil.getEntityManager();
		
		try {
			em.remove(entidade);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir " + entidade.getClass().getSimpleName());			
		}
		
	}

	@Override
	public T findById(ID id) {
		em = JPAUtil.getEntityManager();
		T entity = em.find(classePersistente, id);
		//em.detach(entity);
		//em.close();
		return entity;
	}

	@Override
	public List<T> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
