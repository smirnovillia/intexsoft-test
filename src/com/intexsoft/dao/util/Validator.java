package com.intexsoft.dao.util;

public class Validator {
	
	private static Validator instance;
	
	private Validator() {
	
	}
	
	public static Validator getInstance() {
		if(instance == null) {
			instance = new Validator();
		}
		return instance;
	}
	
	public boolean isValidString(String str) {
		return str.matches("[a-zA-z]+");
	}

}
