package com.home.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * It is very simple and efficient for small data sets 
 * http://www.java2novice.com/java-sorting-algorithms/insertion-sort/
 * compare each other but from current to all the way beginning. 
 * O(n^2)
 * 
 * @author spark
 *
 */
public class InsertionSort {

	public void insertionSort(int[] A) {
		for(int i = 1; i < A.length; i++) {
			for(int j = i; j > 0; j--) {
				if(A[j] < A[j-1]) {
					swapNumbers(j, j - 1, A);
				}
			}
		}
		printNumbers(A);
	}

	private void swapNumbers(int i, int j, int[] A) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public void printNumbers(int[] A) {
		System.out.println( Arrays.stream(A).mapToObj( val -> ((Integer)val).toString() ).collect(Collectors.joining(" ", "[ ", " ]")) );
	}

	public static void main(String[] args) {
		int[] A = {10, 34, 2, 56, 7, 67, 88, 42};
		InsertionSort is = new InsertionSort();
		is.insertionSort(A);
	}
}
