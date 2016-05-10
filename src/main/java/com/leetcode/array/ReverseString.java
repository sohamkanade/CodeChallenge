package com.leetcode.array;

import java.util.Stack;

public class ReverseString {
	public String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		s.chars().forEach(val -> stack.push(val));
		while(!stack.isEmpty()) {
			sb.append((char)stack.pop().intValue());
		}
		return sb.toString();
	}
}
