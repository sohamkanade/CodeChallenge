package com.leetcode.sum;

public class PowerOfFour {
	public boolean isPowerOfFour(int num) {
		return num > 0 && (num & (num - 1)) == 0  && (num & 0x55555555) !=0;
	}

	public boolean isPowerOfTwo(int num) {
	    return (num > 0) && (num & (num-1)) == 0;
	}
	
	public static void main(String[] args) {
		PowerOfFour pof = new PowerOfFour();
		System.out.println( pof.isPowerOfFour(-64) );
	}
}
