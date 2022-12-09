package com.jdc.demo;

import java.util.List;

public interface BaseDao<T> {

	int create(T data);
	void update(int id, T data);
	T findById(int id);
	List<T> getAll();
}
