package com.intexsoft.dao.api;

import java.util.Map;

import com.intexsoft.dao.impl.entity.BaseEntity;

public interface IBaseDao {
	
	void insert(BaseEntity entity);

	void delete(String id);

	String select(String id);

	Map<String, BaseEntity> selectAll();

}
