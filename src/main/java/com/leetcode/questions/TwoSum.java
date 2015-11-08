package com.leetcode.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSum {

	private Map<Integer, Integer> table = new HashMap<>();

	public void add(int input) {
		int count = table.containsKey(input) ? table.get(input) : 0;
		table.put(input, count++);
	}

	public boolean find(int val) {
		for(Map.Entry<Integer, Integer> entry : table.entrySet()) {
			int num = entry.getKey();
			int y = val - num;
			if(y == num) {
				if(entry.getValue() >=2 ) return true;
			} else if (table.containsKey(y)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * In case given array is not sorted
	 * O(n) runtime, O(n) space
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSumHashMap(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < numbers.length; i++) {
			int x = numbers[i];
			if(map.containsKey(target - x)) {
				return new int[] {map.get(target -  x) + 1, i + 1};
			}
			map.put(x, i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * In case array is sorted
	 * O(nlogn) runtime, O(1) space
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSumBinarySearch(int[] numbers, int target) {
		for(int i =0; i < numbers.length; i++) {
			int j = binarySearch(numbers, target - numbers[i], i + 1);
			if(j != -1) {
				return new int[] { i + 1, j + 1 };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	private int binarySearch(int[] A, int key, int start) {
		int L = start, R = A.length -1;
		while(L < R) {
			int M = (L + R) / 2;
			if(A[M] < key) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return ( L == R && A[L] == key) ? L : -1;
	}

	/**
	 * In case array is sorted
	 * O(n) runtime, O(1) space
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSumTwoPointers(int[] numbers, int target) {
		int i = 0, j = numbers.length - 1;
		while(i < j) {
			int sum = numbers[i] + numbers[j];
			if(sum < target) {
				i++;
			} else if ( sum > target) {
				j--;
			} else {
				return new int[] { i + 1, j + 1};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		System.out.println("1. unsorted array - hashmap, target: 10");
		TwoSum ts = new TwoSum();
		int[] A = {8,4,2,7,9,5};
		System.out.println( Arrays.stream(A).mapToObj( i -> ((Integer)i).toString()).collect(Collectors.joining(", ", "{ ", " }")) );
		int[] result1 = ts.twoSumHashMap(A, 10);
		System.out.println( Arrays.stream(result1).mapToObj(i -> ((Integer)i).toString()).collect(Collectors.joining(", ")) );

		System.out.println("\n2. sorted array - binary search, target: 10");
		int[] B = {2,4,5,7,8,9};
		System.out.println( Arrays.stream(B).mapToObj( i -> ((Integer)i).toString()).collect(Collectors.joining(", ", "{ ", " }")) );
		int[] result2 = ts.twoSumBinarySearch(B, 10);
		System.out.println( Arrays.stream(result2).mapToObj(i -> ((Integer)i).toString()).collect(Collectors.joining(", ")) );

		System.out.println("\n3. sorted array - two points, target: 10");
		System.out.println( Arrays.stream(B).mapToObj( i -> ((Integer)i).toString()).collect(Collectors.joining(", ", "{ ", " }")) );
		int[] result3 = ts.twoSumTwoPointers(B, 10);
		System.out.println( Arrays.stream(result3).mapToObj(i -> ((Integer)i).toString()).collect(Collectors.joining(", ")) );
	}
}
