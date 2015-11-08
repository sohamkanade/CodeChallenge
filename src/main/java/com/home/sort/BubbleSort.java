package com.home.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * http://www.java2novice.com/java-sorting-algorithms/bubble-sort/
 * compare just next each other
 * 
 * worst and average complexity both O(n^2)
 * @author spark
 *
 */
public class BubbleSort {

	public void bubbleSort(int[] A) {
		for(int m = A.length; m >=0; m--) {
			for(int i = 0; i < A.length -1; i++) {
				if( A[i] > A[i + 1]) {
					swapNumbers(i, i + 1, A);
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
		int[] A = {5, 1, 12, -5, 16};
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(A);
	}
}
