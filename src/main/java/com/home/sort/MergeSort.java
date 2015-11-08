package com.home.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Merge sort is divide and conquer algorithm.
 * http://www.java2novice.com/java-sorting-algorithms/merge-sort/
 * 
 * @author spark
 * complexity: O(nlogn)
 */
public class MergeSort {

	private int[] array;
	private int[] temp;

	public void mergeSort(int lowerIndex, int higherIndex) {
		if(lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) /2;
			mergeSort(lowerIndex, middle);
			mergeSort(middle +1, higherIndex);
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	public void mergeParts(int lowerIndex, int middle, int higherIndex) {
		for(int i = lowerIndex; i <= higherIndex; i++) {
			temp[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while( i <= middle && j <= higherIndex) {
			if( temp[i] <= temp[j]) {
				array[k] = temp[i];
				i++;
			} else {
				array[k] = temp[j];
				j++;
			}
			k++;
		}
		while(i <= middle) {
			array[k] = temp[i];
			k++;
			i++;
		}
	}

	public void sort(int[] A) {
		this.array = A;
		this.temp = new int[A.length];
		mergeSort(0, A.length - 1);
	}

	public void printNumbers() {
		System.out.println( Arrays.stream(array).mapToObj( val -> ((Integer)val).toString() ).collect(Collectors.joining(" ", "[ ", " ]")) );
	}

	public static void main(String[] args) {
		int[] A ={45,23,11,89,77,98,4,28,65,43};
		MergeSort ms = new MergeSort();
		ms.sort(A);
		ms.printNumbers();
	}
}
