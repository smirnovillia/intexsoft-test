package com.intexsoft.ui.action;

import com.intexsoft.dao.api.enums.Group;

public interface IPayoutEmployee extends IAction{

	double payout(Group group);
	
}
