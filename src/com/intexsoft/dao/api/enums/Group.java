package com.intexsoft.dao.api.enums;

public enum Group {
	EMPLOYE(10), OFFICIAL(10);
	
	private int limit;

	private Group(int limit) {
		this.limit = limit;
	}
	
	public int getLimit() {
		return limit;
	}
}
