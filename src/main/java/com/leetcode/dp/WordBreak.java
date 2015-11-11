package com.leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
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

	public void wordBreak3(String input, Node node) {
		int size = input.length();
		if(size == 0) return;
		for(int i=1; i <=size; i++) {
			String prefix = input.substring(0, i);
			if(dictionaryContains( input.substring(0, i))  ) {
				Node child = new Node(prefix);
				node.getChildren().add(child);
				wordBreak3(input.substring(i, size), child);
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

		Node head = new Node("");
		wb.wordBreak3("ilikeicecreamandmango", head);
		System.out.println();
		//         i
		//         like      
		//  i      ice    icecream
		//         cream        and
		//         and          man mango
		//         man mango    go
		//         go
	}
}
