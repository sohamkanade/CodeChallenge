package com.leetcode.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindSingleNumber {

	public int singleNumber(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int x : A) {
			int count = map.containsKey(x) ? map.get(x) : 0;
			map.put(x, count + 1);
		}
		for(int x : A) {
			if(map.get(x) == 1) {
				return x;
			}
		}
		throw new IllegalArgumentException("No single elemenet");
	}

	public int singleNumber2(int[] A) {
		Set<Integer> set = new HashSet<>();
		for(int x : A) {
			if(set.contains(x)) {
				set.remove(x);
			} else {
				set.add(x);
			}
		}
		return set.iterator().next();
	}

	public int singleNumber3(int[] A) {
		int num = 0;
		for(int x: A) {
			num ^= x;
		}
		return num;
	}
}
