package com.leetcode.questions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.home.test.StringSearch2;

public class StringSearchTests2 {

	private StringSearch2 search;

	@Before
	public void setUp() throws Exception {
		search = new StringSearch2();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(search.findLongestPrefixSuffix("sighten", "ensight"));
		System.out.println(search.findLongestSubstring("sighten", "ensight"));
	}

}
