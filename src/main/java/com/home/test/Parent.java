package com.home.test;

public class Parent {

	private String stringValue;
	private Integer intValue;

	public Parent() {}

	public Parent(String stringValue, Integer intValue) {
		this.stringValue = stringValue;
		this.intValue = intValue;
	}

	public String getStringValue() {
		return stringValue;
	}
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	public Integer getIntValue() {
		return intValue;
	}
	public void setIntValue(Integer intValue) {
		this.intValue = intValue;
	}
}
