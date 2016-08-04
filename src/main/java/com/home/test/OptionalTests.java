package com.home.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalTests {

	private Map<String, String> map = new HashMap<>();

	public static void main(String[] args) {
		OptionalTests ot = new OptionalTests();
		ot.prepareData();
		ot.getValue("key1").ifPresent(System.out::println);
		final String value = ot.getValue("key8").orElseThrow(() -> new RuntimeException("can't find"));
		System.out.println(value);
	}

	public void prepareData() {
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
		map.put("key5", "value5");
	}

	public Optional<String> getValue(String key) {
		if(map.containsKey(key)) {
			return Optional.of(map.get(key));
		}
		return Optional.empty();
	}
}
