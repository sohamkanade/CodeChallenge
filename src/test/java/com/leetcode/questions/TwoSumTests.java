package com.leetcode.questions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoSumTests {

	private TwoSum sum;

	@Before
	public void setUp() throws Exception {
		sum = new TwoSum();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int [] numbers = {4,8,2,7,1,5};
		int [] positions = sum.twoSumHashMap(numbers, 10);
		for(int position: positions) {
			System.out.println(position);
		}
	}

}
