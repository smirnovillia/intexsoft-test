package com.intexsoft.ui.action;

import com.intexsoft.dao.api.enums.Group;

public interface ICountEmployee extends IAction{
	
	int getCount(Group group);

}
