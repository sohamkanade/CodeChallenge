package com.home.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AutoBoxingTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Integer myInteger = new Integer(3);
		assertTrue( myInteger.equals(3) );
	}

}
