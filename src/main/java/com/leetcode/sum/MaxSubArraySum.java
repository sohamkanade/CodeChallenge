package com.leetcode.sum;

public class MaxSubArraySum {

	public int maxSubArrayLen(int[] nums, int k) {
		int sum = 0;
		int len = 0;
		int maxLen = 0;
		for(int i = 0; i < nums.length; i++) {
			sum = nums[i];
			len = 1;
			if(sum == k && len > maxLen) {
				maxLen = len;
			}
			for(int j = i+1; j < nums.length; j++) {
				sum += nums[j];
				len++;
				if(sum == k && len > maxLen) {
					maxLen = len;
				}
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		MaxSubArraySum ms = new MaxSubArraySum();

		int[] nums = {1, -1, 5, -2, 3};
		System.out.println("result; " + ms.maxSubArrayLen(nums, 3));
		// [1, -1, 5, -2]

		int[] nums1 = {-2, -1, 2, 1};
		System.out.println("result; " + ms.maxSubArrayLen(nums1, 1));
		// [-1, 2]

		int[] nums2 = {-1};
		System.out.println("result; " + ms.maxSubArrayLen(nums2, -1));
		// [-1]
	}
}
