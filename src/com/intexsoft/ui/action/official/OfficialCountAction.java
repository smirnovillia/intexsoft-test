package com.intexsoft.ui.action.official;

import com.intexsoft.dao.api.enums.Group;
import com.intexsoft.service.impl.EntityService;
import com.intexsoft.ui.action.ICountEmployee;
import com.intexsoft.ui.util.Printer;

public class OfficialCountAction implements ICountEmployee{

	@Override
	public void execute() {
		Printer.printMessage(String.format("Count of %s is: %s", Group.OFFICIAL.toString(), getCount(Group.OFFICIAL)));
	}

	@Override
	public int getCount(Group group) {
		return EntityService.getInstance().getCount(group);
	}

	

	
	
}
