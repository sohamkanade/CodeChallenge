package com.leetcode.questions;

public class SingleNumber {

	public int singleNumber(int[] A) {
		int num =0;
		for(int x: A) {
			num ^=x;
		}
		return num;
	}

	public static void main(String [] args) {
		int[] A = {1,3,4,6,3,4,1,6,5};
		SingleNumber sn = new SingleNumber();
		System.out.println("answer: " + sn.singleNumber(A));
	}
}
