package com.intexsoft.dao.api;

import com.intexsoft.dao.api.enums.Group;

public interface IEmployeeDao extends IBaseDao{

	boolean isEntityExist(String entity);

	int getCount(Group group);
	
	double getPayout(Group group);
	
	boolean isExceedLimit(Group entity);
}
