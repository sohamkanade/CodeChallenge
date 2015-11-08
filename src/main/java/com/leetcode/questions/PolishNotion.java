package com.leetcode.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PolishNotion {

	public interface Operator {
		int eval(int x, int y);
	}

	private static final Map<String, Operator> OPERATORS = new HashMap<String, Operator>();
	{
		OPERATORS.put("+", (int x, int y) ->{ return x + y;} );
		OPERATORS.put("-", (int x, int y) ->{ return x - y;} );
		OPERATORS.put("*", (int x, int y) ->{ return x * y;} );
		OPERATORS.put("/", (int x, int y) ->{ return x / y;} );
	};

	public int eval(int x, int y, String operator) {
		switch(operator) {
		case "+": return x + y;
		case "-": return x - y;
		case "*": return x * y;
		case "/": return x / y;
		}
		throw new IllegalArgumentException("unknown operator");
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		Arrays.asList(tokens).forEach(token -> {
			if(OPERATORS.containsKey(token)) {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(OPERATORS.get(token).eval(x, y));
			} else {
				stack.push(Integer.parseInt(token));
			}
		});
		return stack.pop();
	}

	public static void main(String[] args) {
		PolishNotion pn = new PolishNotion();
		String[] data1 = {"2","1", "+","3","*"}; //(2+1)*3 = 9
		System.out.println(pn.evalRPN(data1));

		String[] data2 = {"4","13","5","/","+"}; //4+(13/5) = 6
		System.out.println(pn.evalRPN(data2));
	}
}
