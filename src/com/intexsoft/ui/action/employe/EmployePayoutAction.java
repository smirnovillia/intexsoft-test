package com.intexsoft.ui.action.employe;

import com.intexsoft.dao.api.enums.Group;
import com.intexsoft.service.impl.EntityService;
import com.intexsoft.ui.action.IPayoutEmployee;
import com.intexsoft.ui.util.Printer;

public class EmployePayoutAction implements IPayoutEmployee {

	@Override
	public void execute() {
		Printer.printMessage(String.format("Payout for group %s is: %s", Group.EMPLOYE.toString(), payout(Group.EMPLOYE)));
	}

	@Override
	public double payout(Group group) {
		return EntityService.getInstance().getPayout(group);
	}

}
