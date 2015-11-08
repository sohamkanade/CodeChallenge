package com.leetcode.questions;

public class Palindrome {

	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++; j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "A man, a plan, a canal: Panama";
		Palindrome p = new Palindrome();
		System.out.println( p.isPalindrome(input) );
	}
}
