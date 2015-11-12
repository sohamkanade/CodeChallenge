package com.leetcode.array;

import java.util.Arrays;

public class RemoveDuplication {
	public int[] removeDuplicates(int[] nums) {
		if(nums.length < 2) return nums;

		int i = 1;
		int j = 0;

		while( i < nums.length ) {
			if( nums[j] == nums[i] ) {
				i++;
			} else {
				j++;
				nums[j] = nums[i];
				i++;
			}
		}
		return Arrays.copyOf(nums, j+1);
	}

	public int removeDuplicateCount(int[] nums) {
		if(nums.length < 2) return nums.length;

		int i = 1;
		int j = 0;

		while( i < nums.length ) {
			if( nums[j] == nums[i] ) {
				i++;
			} else {
				j++;
				nums[j] = nums[i];
				i++;
			}
		}
		return Arrays.copyOf(nums, j+1).length;
	}

	public int removeDuplicateCount2(int[] nums) {
		int count = 0;
		for(int i = 0; i <nums.length -1; i++) {
			if(nums[i] == nums[i+1]) {
				count++;
			}
		}
		return nums.length - count;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,2}; 
		RemoveDuplication rd = new RemoveDuplication();
		int[] result = rd.removeDuplicates(nums);
		System.out.print("[");
		for(int i = 0; i < result.length; i++) {
			if(i != 0) {
				System.out.print(", ");
			}
			System.out.print(result[i]);
		}
		System.out.println("]");

		System.out.println( rd.removeDuplicateCount2(nums) );
	}
}
