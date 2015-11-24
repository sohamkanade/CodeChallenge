package com.home.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class WiggleSort {

	public void wiggleSort(int[] nums) {
		boolean less = true;
		for(int i = 0 ; i < nums.length -1 ; i++) {
			if(less) {
				if(nums[i] > nums[i+1]) {
					swap(nums, i, i+1);
				}
			} else {
				if(nums[i] <nums[i+1]) {
					swap(nums, i, i+1);
				}
			}
			less = !less;
		}
	}

	public void wiggleSort2(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if((i % 2 == 0) == (nums[i] > nums[i + 1])) {
				swap(nums, i, i + 1);
			}
		}
	}

	private void swap(int [] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private void printArray(int[] nums) {
		Arrays.stream(nums).forEach(System.out::print);
	}

	public static void main(String[] args) {
		int[] nums = IntStream.rangeClosed(1, 6).toArray();
		WiggleSort ws = new WiggleSort();
		ws.printArray(nums);
		System.out.println();

		ws.wiggleSort(nums);

		ws.printArray(nums);
		System.out.println();
	}

}
