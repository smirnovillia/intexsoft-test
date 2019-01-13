package com.intexsoft.ui.action.employe;

import com.intexsoft.dao.api.enums.Group;
import com.intexsoft.service.impl.EntityService;
import com.intexsoft.ui.action.ICountEmployee;
import com.intexsoft.ui.util.Printer;

public class EmployeCountAction implements ICountEmployee {

	@Override
	public void execute() {
		Printer.printMessage(String.format("Count of %s is: %s", Group.EMPLOYE.toString() , getCount(Group.EMPLOYE)));
	}

	@Override
	public int getCount(Group group) {
		return EntityService.getInstance().getCount(group);
	}

}
