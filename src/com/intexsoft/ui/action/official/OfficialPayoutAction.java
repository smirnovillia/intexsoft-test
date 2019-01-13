package com.intexsoft.ui.action.official;

import com.intexsoft.dao.api.enums.Group;
import com.intexsoft.service.impl.EntityService;
import com.intexsoft.ui.action.IPayoutEmployee;
import com.intexsoft.ui.util.Printer;

public class OfficialPayoutAction implements IPayoutEmployee{

	@Override
	public void execute() {
		Printer.printMessage(String.format("Payout for group %s is: %s", Group.OFFICIAL.toString(), payout(Group.OFFICIAL)));
	}

	@Override
	public double payout(Group group) {
		return EntityService.getInstance().getPayout(group);
	}

	
}
