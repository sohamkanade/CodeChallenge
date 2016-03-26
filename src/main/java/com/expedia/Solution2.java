package com.expedia;

public class Solution2 {

	static long kSub(int k, int[] nums) {
		if(k ==0 ) {
			throw new IllegalArgumentException("Invalid input");
		}
		long numKSeq = 0;
		for(int i = 0; i < nums.length; i++) {
			int prev = 0;
			int sum = 0;
			for(int j=i; j < nums.length; j++) {
				if(nums[j] < prev) {
					break;
				}
				prev = nums[j];
				sum += nums[j];
				if(sum% k == 0) {
					numKSeq++;
				}
			}
		}
		return numKSeq;
    }
	

	public static void main(String[] args) {
		int [] arr = {1,2,3,4,1};
		System.out.println(kSub(3, arr));
	}
}
