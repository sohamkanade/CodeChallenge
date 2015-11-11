package com.leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBreak2 {

	// most naive approach
	public boolean wordBreak(String s, Set<String> wordDict) {
		return wordBreakHelper(s, wordDict, 0);
	}

	/**
	 * just check the given string contains any word in dictionary
	 * @param s given input string
	 * @param dict word dictionary
	 * @param start starting position of given input string
	 * @return true if given string contains 
	 */
	public boolean wordBreakHelper(String s, Set<String> dict, int start) {
		if(s.length() == start) return true;

		for(String word : dict) {
			int length = word.length();
			int end = start + length;

			if(end > s.length()) continue;
			if(s.substring(start, end).equalsIgnoreCase(word)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Prevent partial recursion tree worst case issue
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreakDP1(String s, Set<String> wordDict) {
		int size = s.length();
		if(size==0) return true;
		boolean[] wb = new boolean[size+1];
		for(int i = 0; i < wb.length; i++) {
			wb[i] = false;
		}
		for(int i = 1; i <= size; i++) {
			if( wb[i] == false && wordDict.contains(s.substring(0 ,i)) ) {
				wb[i] = true;
			}
			if( wb[i] == true ) {
				if( i == size) return true;
				for(int j = i+1; j<=size; j++) {
					if( wb[j]==false && wordDict.contains(s.substring(i, j)) ){
						wb[j] = true;
					}
					if(j == size && wb[j] == true) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean wordBreakDP2(String s, Set<String> dict) {
		boolean[] wp = new boolean[s.length() + 1];
		wp[0] = true;	// set first to be true, because of we need initial state

		for(int i=0; i < s.length(); i++) {
			if(!wp[i]) continue;

			for(String word : dict) {
				int length = word.length();
				int end = i + length;

				if(end > s.length()) continue;

				if(s.substring(i, end).equalsIgnoreCase(word)) {
					wp[end] = true;
				}
			}
		}
		return wp[s.length()];
	}


	public boolean wordBreakRegex(String s, Set<String> dict) {
		StringBuilder sb = new StringBuilder();
		dict.forEach(word -> {
			if(sb.length() > 0) {
				sb.append("|");
			}
			sb.append(word);
		});

		String patternString = "(".concat(sb.toString()).concat(")*");
		Pattern p = Pattern.compile(patternString);
		Matcher m = p.matcher(s);
		return m.matches();
	}

	public static void main(String[] args) {
		WordBreak2 sol = new WordBreak2();
		Set<String> dict = new HashSet<>(Arrays.asList("leet", "code", "crazy", "for", "code"));
		System.out.println("version1");
		System.out.println( sol.wordBreakDP1("leetcode", dict) );
		System.out.println( sol.wordBreakDP1("crazyforcode", dict) );

		System.out.println("version2");
		System.out.println( sol.wordBreakDP2("leetcode", dict) );
		System.out.println( sol.wordBreakDP2("crazyforcode", dict) );

		System.out.println("version3");
		System.out.println( sol.wordBreakRegex("crazyforcode", dict) );
	}
	
}
