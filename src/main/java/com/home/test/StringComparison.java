package com.home.test;

public class StringComparison {

	public static void main(String[] args) {
		System.out.println("1.5".compareTo("1.5.3"));
		System.out.println("1.5.1".compareTo("1.5.3"));
		System.out.println("1.5.3".compareTo("1.5.3"));
		System.out.println("1.5.5".compareTo("1.5.3"));
	}
}
