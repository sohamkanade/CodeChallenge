package com.leetcode.questions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class longest_stringTests {

	private longest_string search;

	@Before
	public void setUp() throws Exception {
		search = new longest_string();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(search.buildLongestCombinedString("hap", "ppy"));
		System.out.println(search.buildLongestCombinedString("ppy", "hap"));
		System.out.println(search.buildLongestCombinedString("pal", "lap"));
		System.out.println(search.buildLongestCombinedString("lap", "pal"));
		System.out.println(search.buildLongestCombinedString("ensight", "sighten"));
		System.out.println(search.buildLongestCombinedString("sighten", "ensight"));
		System.out.println(search.buildLongestCombinedString("fancy", "dancy"));
		System.out.println(search.buildLongestCombinedString("ensight!", "!sighten"));
		System.out.println(search.buildLongestCombinedString("abcdefgh", "abcdef"));
		System.out.println(search.buildLongestCombinedString("abcdef", "abcdefgh"));
	}

}
