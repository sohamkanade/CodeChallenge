package com.leetcode.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 	Example 1:
	Given s = "hello", return "holle".

	Example 2:
	Given s = "sweetcode", return "sweotcede".

 * @author spark
 *
 */
public class ReverseVowels {
	public String reverseVowels(String s) {
		List<Integer> list = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		s.chars().forEach(val -> {
			char c = (char)val;
			if("aeiouAEIOU".indexOf(c) < 0 ) {
				// no vowel
				list.add(val);
			} else {
				// vawel
				stack.push(val);
				list.add(null);
			}
		});

		StringBuilder sb = new StringBuilder();
		list.stream().forEach(item -> {
			if(null != item) {
				sb.append((char)item.intValue());
			} else {
				sb.append((char)stack.pop().intValue());
			}
		});
		return sb.toString();
	}

	public static void main(String[] args) {
		ReverseVowels rv = new ReverseVowels();
		System.out.println( rv.reverseVowels("SWEETcode") );
		System.out.println( rv.reverseVowels("hello") );
	}
}
