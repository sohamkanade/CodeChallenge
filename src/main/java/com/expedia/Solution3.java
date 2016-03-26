package com.expedia;

/**
 * Missing Words
 * @author spark
 *
 */
public class Solution3 {
	// Julia has a string S, Samantha has stringT which is a subsequence of String S.
	// find out what  words are missing in T
	// list all missing words in T
	// inserting them at the appropriate positions in T in same order
	static int fourthBit(int num) {
		int bit = 0;
		for(int i = 1; i <=4 ; i++) {
			bit = num % 2;
			num = num/2;
		}
		return bit;
    }

}
