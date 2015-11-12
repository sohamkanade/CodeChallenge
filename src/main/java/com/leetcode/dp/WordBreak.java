package com.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	String [] dictionary = {
		"mobile","samsung","sam","sung","man","mango", "icecream","and","go","i","like","ice","cream"
	};

	Set<String> dict = new HashSet<>(Arrays.asList("mobile","samsung","sam","sung","man","mango", "icecream","and","go","i","like","ice","cream"));
	

	public boolean dictionaryContains(String word) {
		return Arrays.stream(dictionary).anyMatch(item -> item.equalsIgnoreCase(word));
	}

	public boolean dictContains(String word) {
		return dict.contains(word);
	}

	public boolean wordBreak(String input) {
		int size = input.length();
		if(size == 0) return true;
		for(int i=1; i <=size; i++) {
			if(dictionaryContains( input.substring(0, i)) && wordBreak(input.substring(i, size)) ) {
				return true;
			}
		}
		return false;
	}


	public boolean wordBreak2(String input) {
		int size = input.length();
		if(size == 0) return true;
		boolean[] wb = new boolean [size+1];
		for(int i=0; i<wb.length; i++) {
			wb[i] = false;
		}

		for(int i=1; i<=size; i++) {
			if(wb[i]==false && dictionaryContains( input.substring(0, i))) {
				wb[i] = true;
				System.out.print(input.substring(0, i)+" ");
			}
			if(wb[i] == true) {
				if(i == size) return true;
				for(int j = i+1; j <=size; j++) {
					if(wb[j] == false && dictionaryContains( input.substring(i, j))) {
						wb[j] = true;
						System.out.print(input.substring(i, j)+" ");
					}
					if(j == size && wb[j] == true) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void wordBreak3(String input, Set<String> dict, String temp, List<String> results) {
		int size = input.length();
		if(size == 0) {
			results.add(temp.trim());
		}
		for(int i=1; i <=size; i++) {
			String prefix = input.substring(0, i);
			if(dict.contains(prefix)  ) {
				wordBreak3(input.substring(i, size), dict, String.join(" ", temp, prefix), results);
			}
		}
	}

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		System.out.println("1. Separated sequence of dictionary words?");
		System.out.println( wb.wordBreak("ilikesamsung") );
		System.out.println( wb.wordBreak("iiiiiiii") );
		System.out.println( wb.wordBreak("") );
		System.out.println( wb.wordBreak("ilikelikeimangoiii") );
		System.out.println( wb.wordBreak("samsungandmango") );
		System.out.println( wb.wordBreak("samsungandmangok") );

		System.out.println("2. Separated sequence of dictionary words?");
		System.out.println( wb.wordBreak2("ilikesamsung") );
		System.out.println( wb.wordBreak2("iiiiiiii") );
		System.out.println( wb.wordBreak2("") );
		System.out.println( wb.wordBreak2("ilikelikeimangoiii") );
		System.out.println( wb.wordBreak2("samsungandmango") );
		System.out.println( wb.wordBreak2("samsungandmangok") );

		Set<String> dict = new HashSet<>(Arrays.asList("mobile","samsung","sam","sung","man","mango", "icecream","and","go","i","like","ice","cream"));
		List<String> results = new ArrayList<>();
		wb.wordBreak3("ilikeicecreamandmango", dict, "", results);
		results.forEach(System.out::println);
	}
}
