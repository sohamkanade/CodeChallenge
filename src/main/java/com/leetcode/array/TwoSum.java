package com.leetcode.array;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		int i = 0;
		int j = numbers.length-1;

		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if(sum < target) {
				i++;
			} else if( sum > target) {
				j--;
			} else {
				result[0] = i+1;
				result[1] = j+1;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		TwoSum ts = new TwoSum();
		int[] result = ts.twoSum(numbers, 9);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
