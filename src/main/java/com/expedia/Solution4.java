package com.expedia;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
	static String[] missingWords(String s, String t) {
		if(s.isEmpty() || t.isEmpty()) {
			throw new IllegalArgumentException("invalid input");
		}
		List<String> missing = new ArrayList<String>();
		String[] array = s.split(" ");
		for(int i = 0; i < array.length; i++) {
			if(!t.contains(array[i])) {
				missing.add(array[i]);
			}
		}
		String[] result = new String[missing.size()];
		result = missing.toArray(result);
		return result;
    }

	
	public static void main(String[] args) {
		String one = "I am using hackerrank to improve programming";
		String two = "am hackerrank to improve";
		String[] result = missingWords(one, two);
		for(String word: result) {
			System.out.println(word);
		}
	}

}
