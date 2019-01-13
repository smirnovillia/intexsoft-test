package com.intexsoft.ui.action.common;

import com.intexsoft.service.impl.EntityService;
import com.intexsoft.ui.action.IFireEmployee;
import com.intexsoft.ui.util.CommonScanner;
import com.intexsoft.ui.util.Printer;

public class AllEmployeeFireAction implements IFireEmployee{

	@Override
	public void execute() {
		Printer.printMessage("Enter last name");
		String lastName = CommonScanner.inputString();
		if (EntityService.getInstance().isEntityExist(lastName)) {
			fire(lastName);
		} else {
			Printer.printMessage("Such user not exist");
		}
	}

	@Override
	public void fire(String employee) {
		EntityService.getInstance().delete(employee);
		Printer.printMessage("Employee fired");
	}
}
