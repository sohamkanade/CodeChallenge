package com.aws;

/**
 * Stair Case
 * 
 * @author spark
 *
 */
public class Solution1 {

	static void StairCase(int n) {
		if (1 > n || 100 < n ) {
			throw new IllegalArgumentException("invalid input");
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <=n; i++) {
			for(int j=1; j <= n; j++) {
				if( (n - j) >= i) {
					sb.append(" ");
				} else {
					sb.append("#");
				}
			}
			System.out.println(sb.toString());
			sb.delete(0, sb.length());
		}
	}

	public static void main(String[] args) {
		StairCase(6);
	}
}
