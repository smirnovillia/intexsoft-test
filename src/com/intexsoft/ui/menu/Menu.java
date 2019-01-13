package com.intexsoft.ui.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private String title;
	private List<MenuItem> menuItems = new ArrayList<>();

	public Menu(String title) {
		this.title = title;
	}

	public Menu(String title, List<MenuItem> menuItems) {
		this.title = title;
		this.menuItems = menuItems;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addMenuItem(MenuItem item) {
		this.menuItems.add(item);
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
}
