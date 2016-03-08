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

	public boolean isPrimeNumber2(int input) {
		if(input <= 0 ) {
			throw new IllegalArgumentException(String.join(": ", "Got inpvalid input", String.valueOf(input)));
		}

		for(int i = 2; i <= (int)Math.sqrt(input); i++) {
			if( input % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PrimeNumber pn = new PrimeNumber();
		System.out.println( pn.isPrimeNumber2(11) );
	}
}
