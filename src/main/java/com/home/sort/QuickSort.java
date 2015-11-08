package com.home.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Quicksort or partition-exchange sort is fast sorting algorithm which is using divide and conquer algorithm
 * http://www.java2novice.com/java-sorting-algorithms/quick-sort/
 * 
 * @author spark
 *
 * complexity: average O(nlogn), worst O(n^2) 
 * 
 * 1. choose pivot - pivot can be the middle index element
 * 2. reorder the list os that all element with values less than the pivot come before the pivot
 *    while all elements with values greater than the pivot come after it.
 *    After this pratitioning, the pivot is in its final positon. this is called the partition operation
 * 3. recursively apply the above steps to the sub-list of elements with smaller values and separately the sub-list
 */
public class QuickSort {

	private int [] array;

	public void sort(int[] A) {
		if( null == A || 0 == A.length) {
			return;
		}
		this.array = A;
		quickSort(0, A.length - 1);
	}

	public void quickSort(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;
		int pivot = array[i + (j - i)/2];
		while(i <= j) {
			// in each iteration, we will identify a number from left side which is greater then the pivot value
			// and also we will identify a number from right side which is less then the pviot value.
			// once the search is done, then we exchange both numbers.
			while(array[i] < pivot) i++;
			while(array[j] > pivot) j--;
			if( i <= j ) {
				swapNumbers(i, j);
				i++;
				j--;
			}
		}
		if(lowerIndex < j) {
			quickSort(lowerIndex, j);
		}
		if(i < higherIndex) {
			quickSort(i, higherIndex);
		}
	}

	private void swapNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void printNumbers() {
		System.out.println( Arrays.stream(array).mapToObj( val -> ((Integer)val).toString() ).collect(Collectors.joining(" ", "[ ", " ]")) );
	}

	public static void main(String[] args) {
		int[] A ={24,2,45,20,56,75,2,56,99,53,12};
		QuickSort qs = new QuickSort();
		qs.sort(A);
		qs.printNumbers();
	}
}
