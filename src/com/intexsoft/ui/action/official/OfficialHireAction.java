package com.intexsoft.ui.action.official;

import com.intexsoft.dao.api.enums.Rate;
import com.intexsoft.dao.impl.entity.BaseEntity;
import com.intexsoft.dao.impl.entity.Official;
import com.intexsoft.dao.util.Validator;
import com.intexsoft.service.impl.EntityService;
import com.intexsoft.ui.action.IHireEmployee;
import com.intexsoft.ui.util.CommonScanner;
import com.intexsoft.ui.util.Printer;

public class OfficialHireAction implements IHireEmployee {

	@Override
	public void execute() {
		Official official = new Official();
		if (EntityService.getInstance().isExceedLimit(official.getGroup())) {
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
		official.setLastName(lastName);
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
		official.setFirstName(firstName.toLowerCase());
		Printer.printMessage("Enter rate");
		Printer.printRateValues();
		String rate;
		while (true) {
			rate = CommonScanner.inputString();
			try {
				official.setRate(Rate.values()[Integer.parseInt(rate) - 1]);
				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				Printer.printMessage("No such rate");
			} catch (NumberFormatException e) {
				Printer.printMessage("Invalid value");
			}
		}
		Printer.printMessage("Enter bonus");
		String bonus;
		while (true) {
			bonus = CommonScanner.inputString();
			try {
				official.setBonusPercent(Integer.parseInt(bonus));
				if(official.getBonusPercent() >= 0 && official.getBonusPercent() <= 100) {
					break;
				}
				else {
					Printer.printMessage("Bonus must be between 0 and 100");
				}
			} catch (NumberFormatException e) {
				Printer.printMessage("Invalid value");
			}
		}
		hire(official);
	}

	@Override
	public void hire(BaseEntity entity) {

		EntityService.getInstance().save(entity);
		Printer.printMessage("Employee hired");

	}

}
