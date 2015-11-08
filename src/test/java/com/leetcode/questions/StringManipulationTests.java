package com.leetcode.questions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringManipulationTests {

	private StringManipulation manipulation;
	
	@Before
	public void setUp() throws Exception {
		manipulation = new StringManipulation();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(manipulation.reverseWords("the sky is blue") );
	}

}
