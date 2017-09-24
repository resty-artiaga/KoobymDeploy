package com.koobym.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.koobym.dao.BaseDao;

public abstract class BaseDaoImpl<T, K extends Serializable> implements BaseDao<T, K> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> entityClass;

	public BaseDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void update(Object t) {
		sessionFactory.getCurrentSession().update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return (List<T>) sessionFactory.getCurrentSession().createCriteria(entityClass).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(K k) {
		return (T) sessionFactory.getCurrentSession().get(entityClass, k);
	}

	@Override
	public void delete(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
