package com.intexsoft.ui.action.common;

import com.intexsoft.service.impl.EntityService;
import com.intexsoft.ui.action.IInfoEmployee;
import com.intexsoft.ui.util.CommonScanner;
import com.intexsoft.ui.util.Printer;

public class AllEmployeeInfoAction implements IInfoEmployee{

	@Override
	public void execute() {
		Printer.printMessage("Enter last name");
		String lastName = CommonScanner.inputString();
		if (EntityService.getInstance().isEntityExist(lastName)) {
			getFullInfo(lastName);
		} else {
			Printer.printMessage("Such user not exist");
		}

	}

	@Override
	public void getFullInfo(String entity) {
		Printer.printMessage(EntityService.getInstance().getFullInfo(entity));
	}
}
