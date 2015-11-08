package com.leetcode.questions;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class StringSearchTests {

	private StringSearch search;

	@Before
	public void setUp() throws Exception {
		search = new StringSearch();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStrStr() {
		assertTrue( 1 == search.strStr("mississippi", "issi") );
	}

	@Test
	public void testLengthOfLongestSubstringTwoDistinct() {
		assertTrue(3 == search.lengthOfLongestSubstringTwoDistinct("eceba"));
	}

	@Test
	public void testLenghtOfLongestSubstring() {
		assertTrue(4 == search.lengthOfLongestSubstring("abdcabdcbb"));
	}

	@Test
	public void testLengthOfLongestSubstringTwoDistinct2() {
		assertTrue(3 == search.lengthOfLongestSubstringTwoDistinct2("eceba"));
	}

	@Ignore
	@Test
	public void testLengthOfLongestSubstringTwoDistinct21() {
		assertTrue(5 == search.lengthOfLongestSubstringTwoDistinct2("ecgbecgba"));
	}
}
