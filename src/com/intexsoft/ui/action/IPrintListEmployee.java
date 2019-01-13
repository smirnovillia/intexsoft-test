package com.intexsoft.ui.action;

import java.util.Map;

import com.intexsoft.dao.impl.entity.BaseEntity;

public interface IPrintListEmployee extends IAction{
	
	void printEmployee(Map<String, BaseEntity> employee);

}
