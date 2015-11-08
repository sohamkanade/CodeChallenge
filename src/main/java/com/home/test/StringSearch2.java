package com.home.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSearch2 {
	public String findLongestPrefixSuffix(String s1, String s2) {
		for( int i = Math.min(s1.length(), s2.length()); ; i--) {
			if(s2.endsWith(s1.substring(0, i))) {
				return s1.substring(0, i);
			}
		}
	}

	public String findLongestSubstring(String s1, String s2) {
		List<Integer> occurs = new ArrayList<>();
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(s2.length()-1)) {
				occurs.add(i);
			}
		}

		Collections.reverse(occurs);

		for(int index : occurs) {
			boolean equals = true;
			for(int i = index; i >= 0; i--) {
				if (s1.charAt(index-i) != s2.charAt(s2.length() - i - 1)) {
					equals = false;
					break;
				}
			}
			if(equals) {
				return s1.substring(0,index+1);
			}
		}

		return null;
	}
}
