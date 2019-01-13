package com.intexsoft.ui.builder;

import com.intexsoft.ui.action.common.AllEmployeeFireAction;
import com.intexsoft.ui.action.common.AllEmployeeInfoAction;
import com.intexsoft.ui.action.common.AllEmployeePayoutAction;
import com.intexsoft.ui.action.common.AllEmployeePrintListAction;
import com.intexsoft.ui.action.employe.EmployeCountAction;
import com.intexsoft.ui.action.employe.EmployeHireAction;
import com.intexsoft.ui.action.employe.EmployePayoutAction;
import com.intexsoft.ui.action.official.OfficialCountAction;
import com.intexsoft.ui.action.official.OfficialHireAction;
import com.intexsoft.ui.action.official.OfficialPayoutAction;
import com.intexsoft.ui.menu.Menu;
import com.intexsoft.ui.menu.MenuItem;

public class Builder {
	
	private Menu rootMenu;
	private Menu hireMenu;
	private Menu fireMenu;
	private Menu showCountMenu;
	private Menu showInfoMenu;
	private Menu payoutMenu;
	private Menu printListMenu;
	
	public Builder() {
		this.rootMenu = buildRootMenu();
	}

	public Menu getRootMenu() {
		return rootMenu;
	}

	private Menu buildRootMenu() {
		rootMenu = new Menu("Root menu");
		rootMenu.addMenuItem(new MenuItem("Hire employee", buildEmployeeHireMenu()));
		rootMenu.addMenuItem(new MenuItem("Fire employee", builEmployeeFireMenu()));
		rootMenu.addMenuItem(new MenuItem("Show count of employee", buildEmployeeShowCountMenu()));
		rootMenu.addMenuItem(new MenuItem("Show info of employee", buildEmployeeShowInfoMenu()));
		rootMenu.addMenuItem(new MenuItem("Show payout of employee", buildEmployeePayoutMenu()));
		rootMenu.addMenuItem(new MenuItem("Print list of employee", buildEmployeePrintListMenu()));
		rootMenu.addMenuItem(new MenuItem("Exit"));
		return rootMenu;
	}
	
	private Menu buildEmployeeHireMenu() {
		hireMenu = new Menu("Hire employee menu");
		hireMenu.addMenuItem(new MenuItem("Hire employe", hireMenu, new EmployeHireAction()));
		hireMenu.addMenuItem(new MenuItem("Hire official", hireMenu, new OfficialHireAction()));
		hireMenu.addMenuItem(new MenuItem("Back", rootMenu));
		return hireMenu;
	}
	
	private Menu builEmployeeFireMenu() {
		fireMenu = new Menu("Fire employee menu");
		fireMenu.addMenuItem(new MenuItem("Fire employee", fireMenu, new AllEmployeeFireAction()));
		fireMenu.addMenuItem(new MenuItem("Back", rootMenu));
		return fireMenu;
	}
	
	private Menu buildEmployeeShowCountMenu() {
		showCountMenu = new Menu("Show count of employee menu");
		showCountMenu.addMenuItem(new MenuItem("Show count of employe", showCountMenu, new EmployeCountAction()));
		showCountMenu.addMenuItem(new MenuItem("Show count of official", showCountMenu, new OfficialCountAction()));
		showCountMenu.addMenuItem(new MenuItem("Back", rootMenu));
		return showCountMenu;
	}
	
	private Menu buildEmployeeShowInfoMenu() {
		showInfoMenu = new Menu("Show info of employee menu");
		showInfoMenu.addMenuItem(new MenuItem("Show employee info", showInfoMenu, new AllEmployeeInfoAction()));
		showInfoMenu.addMenuItem(new MenuItem("Back", rootMenu));
		return showInfoMenu;
	}
	
	private Menu buildEmployeePayoutMenu() {
		payoutMenu = new Menu("Payout menu");
		payoutMenu.addMenuItem(new MenuItem("Show all employee payout", payoutMenu, new AllEmployeePayoutAction()));
		payoutMenu.addMenuItem(new MenuItem("Show employe payout", payoutMenu, new EmployePayoutAction()));
		payoutMenu.addMenuItem(new MenuItem("Show official payout", payoutMenu, new OfficialPayoutAction()));
		payoutMenu.addMenuItem(new MenuItem("Back", rootMenu));
		return payoutMenu;
	}
	
	private Menu buildEmployeePrintListMenu() {
		printListMenu = new Menu("Print list of employee menu");
		printListMenu.addMenuItem(new MenuItem("Print list of employee", printListMenu, new AllEmployeePrintListAction()));
		printListMenu.addMenuItem(new MenuItem("Back", rootMenu));
		return printListMenu;
	}
	
}
