package com.home.test;

import java.util.Stack;

public class Solution2 {
	public int calculate(String s) {
		Stack<Integer> nums = new Stack<Integer>();
		Stack<Character> op = new Stack<Character>();

		for(int i=0; i< s.length(); i++) {
			if(s.charAt(i) >= '0') {
				int number = 0;
				while(i < s.length() && s.charAt(i) >= '0') {
					number = 10 * number + s.charAt(i++) - '0';
				}
				i--;
				nums.push(number);
			} else if (s.charAt(i) == ' ') {
				continue;
			} else {
				if(s.charAt(i) == '+' || s.charAt(i) == '-') {
					op.push(s.charAt(i));
				} else {
					// get second operand
					int number = 0;
					char operator = s.charAt(i);
					// remove white space
					do {
						i++;
					} while(s.charAt(i) == ' ');

					if(s.charAt(i) >= '0') {
						while(i < s.length() && s.charAt(i) >= '0') {
							number = 10 * number + s.charAt(i++) - '0';
						}
						i--;
					} 
					nums.push(cal(nums.pop(), operator, number));
				}
			}
		}
		// now all remains are '+' or '-' calculation
		// let's reverse number stack and operator stack to calculate from left to right
		Stack<Integer> reverseNums = new Stack<Integer>();
		Stack<Character> reverseOp = new Stack<Character>();
		
		while(nums.size() >0) {
			reverseNums.push(nums.pop());
		}
		while(op.size() > 0) {
			reverseOp.push(op.pop());
		}
		
		while (reverseOp.size() > 0) {
			reverseNums.push(cal(reverseNums.pop(), reverseOp.pop(), reverseNums.pop()));
		}
		// probably left only one 
		return reverseNums.pop();
	}
	
	public int cal(int op1, char oper, int op2) {
		int result = 0;
		switch (oper)  {
		case '+':
			result = (op1 + op2);
			break;

		case '-':
			result = (op1 - op2 );
			break;

		case '/':
			result = (op1 / op2);
			break;

		case '*':
			result = (op1 * op2);
			break;
		}
		return result;
	}
}
