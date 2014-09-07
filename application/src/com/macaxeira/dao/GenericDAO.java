package com.macaxeira.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		return entidade;
	}
	
	
	@Override
	public void delete(ID id) throws Exception {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			T entity = em.find(classePersistente, id);
			em.remove(entity);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			throw e;
		}finally{
			em.close();
		}
	}

	

	@Override
	public T findById(ID id) {
		em = JPAUtil.getEntityManager();
		T entity = em.find(classePersistente, id);

		return entity;
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {
		em = JPAUtil.getEntityManager();
		
		Query query = em.createQuery("SELECT e FROM Categoria e");
	    return  query.getResultList();
		
	}


	

}
