package com.home.test;

import java.util.HashMap;
import java.util.Map;

public class Child extends Parent {

	private Map<String, String> values;

	public Map<String, String> getValues() {
		if(null == values) {
			values = new HashMap<>();
		}
		return values;
	}
}
