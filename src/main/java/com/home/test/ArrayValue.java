package com.home.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayValue {

	public int maxSubArray(int[] A) {
		int newSum = A[0];
		int max = A[0];
		for(int i = 1; i < A.length; i++) {
			newSum = Math.max(newSum + A[i], A[i]);
			max = Math.max(max, newSum);
		}
		return max;
	}

	public void findMinMax(int[] A) {
		List<Integer> data = new ArrayList<>();
		for(int i = 0; i < A.length; i++) {
			data.add(A[i]);
		}
		System.out.println( "Min: " + Collections.min(data) );
		System.out.println( "Max: " + Collections.max(data) );
	}

	public void getPossibleSubArray(int[] A) {
		Integer[] intArray = new Integer[A.length];

		for(int i = 0; i < A.length; i++) {
			intArray[i] = Integer.valueOf(A[i]);
		}
		for(int i = 0; i < intArray.length - 1; i++) {
			for(int j = i + 1; j < intArray.length - 1; j++) {
				List<Integer> subList = Arrays.asList(intArray).subList(i, j);
				subList.forEach(System.out::print);
				System.out.println();
				int[] ret = new int[subList.size()];
				for(int k = 0; k < ret.length; k++) {
					ret[k] = subList.get(k);
				}
				findMinMax(ret);
				System.out.println();
			}
		}
		
	}

	public static void main(String[] args) {
		int [] A = {-2,1,-3,4,-1,2,1,-5,4};
		ArrayValue arrayValue = new ArrayValue();
		arrayValue.findMinMax(A);
		System.out.println( "Max SubArray: " + arrayValue.maxSubArray(A) );
		arrayValue.getPossibleSubArray(A);
	}
}
