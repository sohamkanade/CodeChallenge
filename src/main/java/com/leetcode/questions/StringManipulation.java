package com.leetcode.questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringManipulation {
	public String reverseWords(String s) {
		String[] values = s.split(" ");
		Collections.reverse(Arrays.asList(values));
		List<String> filteredValues = Stream.of(values).filter(value -> value.length() > 0).collect(Collectors.toList());
		if(filteredValues.size() == 1) {
			return filteredValues.get(0);
		}
		return String.join(" ", filteredValues);
	}
}
