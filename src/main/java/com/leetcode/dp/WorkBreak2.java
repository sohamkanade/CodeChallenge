package com.leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WorkBreak2 {
	public boolean wordBreak(String s, Set<String> wordDict) {
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

	public static void main(String[] args) {
		WorkBreak2 sol = new WorkBreak2();
		Set<String> dict = new HashSet<>(Arrays.asList("leet", "code", "crazy", "for", "code"));
		System.out.println( sol.wordBreak("leetcode", dict) );
		System.out.println( sol.wordBreak("crazyforcode", dict) );
	}
	
}
