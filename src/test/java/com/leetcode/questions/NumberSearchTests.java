package com.leetcode.questions;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NumberSearchTests {

	private NumberSearch search;

	@Before
	public void setUp() throws Exception {
		search = new NumberSearch();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindMissinRanges() {
		int[] values = {0,1,3,50,75};
		List<String> ranges = search.findMissingRanges(values, 0, 99);
		ranges.forEach(System.out::println);
	}

}
