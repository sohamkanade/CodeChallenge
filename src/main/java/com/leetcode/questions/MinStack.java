package com.leetcode.questions;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public void push(int x) {
		stack.push(x);
		if(minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public int pop() {
		Integer value = stack.pop();
		if(value.equals(minStack.peek())) {
			minStack.pop();
		}
		return value;
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		int [] data = {1,4,3,0,4};

		System.out.println("1. adding data to minStack");
		for(int val : data) {
			minStack.push(val);
			System.out.println("added value: " + val + ", min value: " + minStack.getMin());
		}

		System.out.println("\n2. removing data from minStack");
		while(!minStack.isEmpty()) {
			System.out.println("min value: " + minStack.getMin());
			System.out.println("removed value: " + minStack.pop());
		}
	}
}
