package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

public class NumArray {
	private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

	public NumArray(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			int sum = 0;
			for(int j = i; j < nums.length; j++) {
				sum += nums[j];
				map.put(Pair.of(i, j), sum);
			}
		}
	}

	public int sumRange(int i, int j) {
		return map.get(Pair.of(i, j));
	}
}
