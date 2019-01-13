package com.intexsoft.dao.api.enums;

public enum Rate {
	HALF(0.5), FULL(1.0), ENLARGED(1.25);
	
	private double rate;
	
	private Rate(double rate) {
		this.rate = rate;
	}

	public double getValue() {
		return rate;
	}
	
}
