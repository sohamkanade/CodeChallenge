package com.leetcode.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class ParlindromeNumber {
	public boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		List<Integer> list = new LinkedList<>();
		do {
			list.add(x %10);
			x = x/10;
		} while(x > 0);
		for(int i = 0; i < list.size()/2; i++) {
			if(list.get(i) != list.get(list.size()-1-i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ParlindromeNumber PN = new ParlindromeNumber();
		System.out.println(PN.isPalindrome(0) );
	}
}
