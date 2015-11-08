package com.leetcode.questions;

public class StringToInteger {

	private static final int maxDiv10 = Integer.MAX_VALUE / 10;

	public int atoi(String s) {
		int i =0, n = s.length();
		while( i < n && Character.isWhitespace(s.charAt(i))) i++;
		int sign = 1;
		if( i < n && s.charAt(i) == '+') {
			i++;
		} else if( i < n && s.charAt(i) == '-') {
			sign = -1;
			i++;
		}

		int num = 0;
		while ( i < n && Character.isDigit(s.charAt(i)) ) {
			int digit = Character.getNumericValue(s.charAt(i));
			if(num > maxDiv10 || num == maxDiv10 && digit >= 8) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
		return sign * num;
	}

	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		int result = sti.atoi("2147483647");
		System.out.println(result);
	}
}
