package com.koobym.service;

import java.util.List;

public interface BaseService<T,K> {
	public void save(T t);

	public void update(T t);

	public List<T> list();

	public T get(K k);

	public void delete(K k);
}
