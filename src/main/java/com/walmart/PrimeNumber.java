package com.walmart;

public class PrimeNumber {

	public boolean isPrimeNumber(int input) {
		if(input <= 0 ) {
			throw new IllegalArgumentException(String.join(": ", "Got inpvalid input", String.valueOf(input)));
		}

		for(int i = 2; i < input; i++) {
			if( input % i == 0) {
				return false;
			}
		}
		return true;
	}
}
