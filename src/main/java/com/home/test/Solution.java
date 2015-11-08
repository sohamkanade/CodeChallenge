package com.home.test;

import java.util.Stack;

/**
 * re-consider this to handle double digit
 * @author spark
 *
 */
public class Solution {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int calculate(String s) {
		Stack stack = new Stack();
		for(int i=0; i< s.length(); i++) {
			char ch = s.charAt(i);
			if( ch != ' ') {
				if( ch != '*' && ch != '/') {
					stack.push(ch);
				} else {
					char op2 = ' ';
					do {
						i++;
						op2 = s.charAt(i);
					} while(op2 == ' ');
					stack.push(cal((Character) stack.pop(), ch, op2));
				}
			}
		}
		while (stack.size() > 1 ) {
			stack.push(cal((Character)stack.pop(), (Character)stack.pop(), (Character)stack.pop()));
		};
		return (Character)stack.pop() - '0';
	}

	public char cal(char op1, char oper, char op2) {
		char result = '0';
		switch (oper)  {
		case '+':
			result = (char) ((op1 - '0') + (op2 - '0') + '0');
			break;

		case '-':
			result = (char) ((op1 - '0') - (op2 - '0') + '0');
			break;

		case '/':
			result = (char) ((op1 - '0') / (op2 - '0') + '0');
			break;

		case '*':
			result = (char) ((op1 - '0') * (op2 - '0') + '0');
			break;
		}
		return result;
	}
}
