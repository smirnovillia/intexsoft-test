package com.intexsoft.ui.controller;

import com.intexsoft.ui.builder.Builder;
import com.intexsoft.ui.navigation.Navigator;
import com.intexsoft.ui.util.CommonScanner;
import com.intexsoft.ui.util.Printer;

public class EmployeeController {

	private Navigator navigator;
	private Builder builder;
	private boolean exit = false;

	public void run() {
		builder = new Builder();
		navigator = new Navigator();
		navigator.setCurrentMenu(builder.getRootMenu());
		navigator.printMenu();
		Integer index = null;
		while (!exit) {
			
			String input = CommonScanner.inputString();
			try {
				index = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Wrong symbol or number");
			}
			if (index > 0 && index <= navigator.getCurrentMenu().getMenuItems().size()) {
				navigator.navigate(index - 1);
				
				if(navigator.getCurrentMenu().equals(builder.getRootMenu()) && navigator.getCurrentMenu().getMenuItems().get(index - 1).getTitle().equals("Exit")) {
					exit = true;
					System.out.println("Good bye!");
					break;
				}
				
				navigator.printMenu();
				
			} else {
				Printer.printMessage("Choose rigth action");
			}
			
		}
		CommonScanner.closeScanner();
	}

}
