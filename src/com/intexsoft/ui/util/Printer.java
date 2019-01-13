package com.intexsoft.ui.util;

import java.util.Map;

import com.intexsoft.dao.api.enums.Rate;
import com.intexsoft.dao.impl.entity.BaseEntity;

public class Printer {
	
	public static void printMessage(String str) {
		System.out.println(str);
	}
	
	public static void printEmployeeList(Map<String, BaseEntity> employee) {
		int id = 1;
		for (Map.Entry<String, BaseEntity> entity : employee.entrySet()) {
			System.out.println(String.format("ID = %s : %s", id, entity.getValue()));
			id++;
		}
	}
	
	public static void printRateValues() {
		int i = 1;
		for (Rate theRate : Rate.values()) {
			System.out.print(String.format("%s. %s - %s | ", i , theRate.toString(), theRate.getValue()));
			i++;
		}
	}
}
