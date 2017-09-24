package com.koobym.dao;

import java.util.List;

public interface BaseDao<T, K> {
	public void save(T t);

	public void update(T t);

	public List<T> list();

	public T get(K k);

	public void delete(T t);
}
