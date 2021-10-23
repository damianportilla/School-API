package com.school.generics;

import java.util.List;

public interface CrudActions<T , ID> {

	void create(T ob);
	
	T getById(ID id);
	
	List<T> getByName(String name);
	
	List<T> getAll();
	
	void update(T ob);
	
	void remove(ID id);
	
}
