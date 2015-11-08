package com.leetcode.questions;

public class MaxProductSubArray {

	public int maxProduct(int[] A) {
		assert A.length > 0;
		int max = A[0], min = A[0], maxAns = A[0];
		for(int i = 1; i < A.length; i++) {
			max = Math.max(Math.max(A[i], max * A[i]), min * A[i]);
			min = Math.min(Math.min(A[i], max * A[i]), min * A[i]);
			maxAns = Math.max(max, maxAns);
		}
		return maxAns;
	}

	public static void main(String[] args) {
		int[] A ={2,3,-2,4};
		MaxProductSubArray mp = new MaxProductSubArray();
		System.out.println(mp.maxProduct(A));
	}
}
