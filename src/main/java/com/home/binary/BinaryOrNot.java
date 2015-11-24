package com.home.binary;

public class BinaryOrNot {
	static boolean isBinaryOrNot(int number) {
		int copyOfNumber = number;

		while(copyOfNumber != 0) {
			int temp = copyOfNumber % 10;
			if(temp > 1) {
				return false;
			} else {
				copyOfNumber = copyOfNumber /10;
			}
		}
		return true;
	}
}
