package com.home.test;

import java.math.BigDecimal;

public class BigDecimalCalculation {

	public static void main(String[] args) {
		BigDecimal value1 = new BigDecimal("12.0");
		BigDecimal value2 = new BigDecimal("23.1");
		BigDecimal value3 = new BigDecimal("0.0");
		BigDecimal value4 = new BigDecimal("-50.0");

		System.out.println(value1.compareTo(value2));
		System.out.println(value1.compareTo(value3));
		System.out.println(value4.compareTo(value3) != 0);
	}
}
