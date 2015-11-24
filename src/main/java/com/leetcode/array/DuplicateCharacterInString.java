package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharacterInString {
	public static void duplicateCharCount(String input) {
		Map<Character, Integer> charCountMap = new HashMap<>();

		char[] charArray = input.toCharArray();

		for(char c: charArray) {
			if(charCountMap.containsKey(c)) {
				charCountMap.put(c,  charCountMap.get(c) + 1);
			} else {
				charCountMap.put(c, 1);
			}
		}

		Set<Character> charsInString = charCountMap.keySet();
		for(Character ch : charsInString) {
			if(charCountMap.get(ch) > 1) {
				System.out.println(ch + ":" + charCountMap.get(ch));
			}
		}
	}

	public static void main(String[] args)
	{
		duplicateCharCount("JavaJ2EE");

		duplicateCharCount("Fresh Fish");

		duplicateCharCount("Better Butter");
	}
}
