package com.intexsoft.ui.navigation;

import static com.intexsoft.ui.util.Printer.*;

import com.intexsoft.ui.menu.Menu;
import com.intexsoft.ui.menu.MenuItem;

public class Navigator {

	private Menu currentMenu;

	public Menu getCurrentMenu() {
		return currentMenu;
	}

	public void setCurrentMenu(Menu currentMenu) {
		this.currentMenu = currentMenu;
	}

	public void printMenu() {

		printMessage(currentMenu.getTitle());
		int i = 1;
		for (MenuItem menuItem : currentMenu.getMenuItems()) {
			printMessage(i + "." + menuItem.getTitle());
			i++;
		}
	}

	public void navigate(Integer index) {
		
		if(currentMenu.getMenuItems().get(index).getAction() != null) {
			currentMenu.getMenuItems().get(index).doAction();
		}
		if(currentMenu.getMenuItems().get(index).getNextMenu() != null) {
			currentMenu = currentMenu.getMenuItems().get(index).getNextMenu();
		}
	}
}
