package com.home.test;

import java.util.StringJoiner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringJoinerTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		StringJoiner sj = new StringJoiner("", "\"", "\"");
		System.out.println(sj.add("my data").toString());
	}

}
