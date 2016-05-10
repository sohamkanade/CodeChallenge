package com.leetcode.sum;

import java.util.ArrayList;
import java.util.List;

public class IntegerBreak {
	public int integerBreak(int n) {
		if (n <= 3) return n - 1;
		List<Integer> dp = new ArrayList<>();
		dp.add(0, 0);
		dp.add(1, 0);
		dp.add(2, 2);
		dp.add(3, 3);
		for (int i = 4; i <= n; ++i) {
			dp.add(i, Math.max(2 * dp.get(i - 2), 3 * dp.get(i - 3)) );
		}
		return dp.get(n);
	}

	public static void main(String[] args) {
		IntegerBreak ib = new IntegerBreak();
		System.out.println( ib.integerBreak(5) );
	}
}
