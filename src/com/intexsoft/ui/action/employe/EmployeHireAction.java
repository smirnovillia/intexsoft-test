package com.intexsoft.ui.action.employe;

import com.intexsoft.dao.api.enums.Rate;
import com.intexsoft.dao.impl.entity.BaseEntity;
import com.intexsoft.dao.impl.entity.Employe;
import com.intexsoft.dao.util.Validator;
import com.intexsoft.service.impl.EntityService;
import com.intexsoft.ui.action.IHireEmployee;
import com.intexsoft.ui.util.CommonScanner;
import com.intexsoft.ui.util.Printer;

public class EmployeHireAction implements IHireEmployee {

	@Override
	public void execute() {
		Employe employe = new Employe();
		if (EntityService.getInstance().isExceedLimit(employe.getGroup())) {
			Printer.printMessage("Sorry, we don't appears to hire you");
			return;
		}
		Printer.printMessage("Enter last name");
		String lastName;
		while (true) {
			lastName = CommonScanner.inputString();
			if (EntityService.getInstance().isEntityExist(lastName)) {
				Printer.printMessage("Such user exist");
				continue;
			}
			if (Validator.getInstance().isValidString(lastName)) {
				break;
			} else {
				Printer.printMessage("Invalid symbols");
			}
		}
		employe.setLastName(lastName);
		Printer.printMessage("Enter first name");
		String firstName;
		while (true) {
			firstName = CommonScanner.inputString();
			if (Validator.getInstance().isValidString(firstName)) {
				break;
			} else {
				Printer.printMessage("Invalid symbols");
			}
		}
		employe.setFirstName(firstName.toLowerCase());
		Printer.printMessage("Enter rate");
		Printer.printRateValues();
		String rate;
		while (true) {
			rate = CommonScanner.inputString();
			try {
				employe.setRate(Rate.values()[Integer.parseInt(rate) - 1]);
				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				Printer.printMessage("No such rate");
			} catch (NumberFormatException e) {
				Printer.printMessage("Invalid value");
			}
		}
		hire(employe);
	}

	@Override
	public void hire(BaseEntity entity) {

		EntityService.getInstance().save(entity);
		Printer.printMessage("Employee hired");

	}

}
