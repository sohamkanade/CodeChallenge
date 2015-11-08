package com.leetcode.questions;

import java.util.Arrays;

public class StringSearch {
	public int strStr(String haystack, String needle) {
		for(int i = 0;  ;i++) {
			for(int j = 0;  ; j++) {
				if(j == needle.length()) return i;
				if(i + j == haystack.length()) return -1;
				if(needle.charAt(j) != haystack.charAt(i + j)) break;
			}
		}
	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int i = 0, j = -1, maxLen = 0;
		for(int k = 1; k < s.length(); k++) {
			if(s.charAt(k) == s.charAt(k - 1)) continue;
			if( j >= 0 && s.charAt(j) != s.charAt(k)) {
				maxLen = Math.max(k - i, maxLen);
				i = j + 1;
				System.out.println("i="+i);
			}
			j = k - 1;
			System.out.println("j="+j);
		}
		return Math.max(s.length() - i, maxLen);
	}

	public int lengthOfLongestSubstring(String s) {
		int[] charMap = new int[256];
		Arrays.fill(charMap, -1);
		int i =0, maxLen = 0;
		for(int j = 0; j < s.length(); j++) {
			System.out.println("j          : " + j);
			System.out.println("i          : " + i);
			System.out.println("s.charAt(j): " + s.charAt(j));
			System.out.println("charMap[s.charAt(j)]: " + charMap[s.charAt(j)]);
			if(charMap[s.charAt(j)] >= i) {
				i = charMap[s.charAt(j)] + 1;
			}
			charMap[s.charAt(j)] = j;
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}

	public int lengthOfLongestSubstringTwoDistinct2(String s) {
		int [] count = new int[256];
		int i =0, numDistinct = 0, maxLen = 0;
		for(int j = 0;  j < s.length(); j++) {
			if(count[s.charAt(j)] == 0) numDistinct++;
			count[s.charAt(j)]++;
			System.out.println("j          : " + j);
			System.out.println("s.charAt(j): " + s.charAt(j));
			System.out.println("numDistinct: " + numDistinct);
			while(numDistinct > 2) {
				System.out.println("< in while >");
				count[s.charAt(i)]--;
				if(count[s.charAt(i)] == 0) numDistinct--;
				System.out.println("i          : " + i);
				System.out.println("s.charAt(i): " + s.charAt(i));
				System.out.println("numDistinct: " + numDistinct);
				i++;
			}
			maxLen = Math.max(j - i + 1, maxLen);
			System.out.println("maxLen     : " + maxLen);
		}
		return maxLen;
	}
}
