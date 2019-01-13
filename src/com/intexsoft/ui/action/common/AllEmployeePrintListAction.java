package com.intexsoft.ui.action.common;

import java.util.Map;

import com.intexsoft.dao.impl.entity.BaseEntity;
import com.intexsoft.service.impl.EntityService;
import com.intexsoft.ui.action.IPrintListEmployee;
import com.intexsoft.ui.util.Printer;

public class AllEmployeePrintListAction implements IPrintListEmployee{

	@Override
	public void execute() {
		printEmployee(EntityService.getInstance().getAll());
	}

	@Override
	public void printEmployee(Map<String, BaseEntity> employee) {
		Printer.printEmployeeList(employee);
	}

	
}
