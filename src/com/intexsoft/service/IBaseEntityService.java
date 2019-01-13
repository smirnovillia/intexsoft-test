package com.intexsoft.service;

import java.util.Map;

import com.intexsoft.dao.api.enums.Group;
import com.intexsoft.dao.impl.entity.BaseEntity;

public interface IBaseEntityService {
	
	void save(BaseEntity entity);

	void delete(String id);

	Map<String, BaseEntity> getAll();

	String getFullInfo(String id);

	double getPayout(Group group);

	int getCount(Group group);
	
	boolean isEntityExist(String entity);
	
	boolean isExceedLimit(Group group);
	
}
