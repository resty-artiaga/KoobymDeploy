package com.koobym.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import com.koobym.dao.BaseDao;
import com.koobym.service.BaseService;

@Transactional
public abstract class BaseServiceImpl<T,K extends Serializable> implements BaseService<T,K> {
	
	private BaseDao<T,K> baseDao;
	
	public BaseServiceImpl(BaseDao<T,K> baseDao){
		this.baseDao = baseDao;
	}
	
	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public List<T> list() {
		return baseDao.list();
	}

	@Override
	public T get(K k) {
		return baseDao.get(k);
	}

	@Override
	public void delete(K k) {
		baseDao.delete(baseDao.get(k));		
	}

}
