package com.aws;

/**
 * Sum of Integers
 * @author spark
 *
 */
public class Solution2 {

	static long sumOfIntegers(int[] arr) {
		int size = arr[0];
		if(size != arr.length - 1) {
			throw new IllegalArgumentException("");
		}
		long sum = 0;
		for(int i = 1; i <= size; i++) {
			sum += arr[i];
		}
		return sum;
    }

	public static void main(String[] args) {
		int[] arr = {2, 12, 12};
		System.out.println(sumOfIntegers(arr));
	}
}
