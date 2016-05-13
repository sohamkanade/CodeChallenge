package com.home.format.csv;

import java.lang.reflect.Field;

public class ReflectionTest {

	public static void main(String[] args) {
		Class employee = Employee.class;
		Field[] publicFields = employee.getFields();  // only public field
		System.out.println(publicFields.length);
		System.out.println(Employee.class.getDeclaredFields().length);
	}
}
