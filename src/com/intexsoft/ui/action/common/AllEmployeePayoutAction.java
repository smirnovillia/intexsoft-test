package com.intexsoft.ui.action.common;

import com.intexsoft.dao.api.enums.Group;
import com.intexsoft.service.impl.EntityService;
import com.intexsoft.ui.action.IPayoutEmployee;
import com.intexsoft.ui.util.Printer;

public class AllEmployeePayoutAction implements IPayoutEmployee{

	@Override
	public void execute() {
		double allPayout = payout(Group.EMPLOYE) + payout(Group.OFFICIAL);
		Printer.printMessage(String.format("Payout for all employee is: %s", allPayout));
		
	}

	@Override
	public double payout(Group group) {
		return EntityService.getInstance().getPayout(group);
	}

	
}
