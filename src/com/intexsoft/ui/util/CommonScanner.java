package com.intexsoft.ui.util;

import java.util.Scanner;

public class CommonScanner {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static String inputString() {
		return sc.nextLine();
	}
	
	public static int inputInteger() {
		return sc.nextInt();
	}
	
	public static double inputDouble() {
		return sc.nextDouble();
	}
	
	public static void closeScanner () {
		sc.close();
	}
}
