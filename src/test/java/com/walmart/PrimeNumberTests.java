package com.walmart;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrimeNumberTests {

	private PrimeNumber pn;

	@Before
	public void setUp() throws Exception {
		pn = new PrimeNumber();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsPrimeNumberWithValidInput() {
		Assert.assertFalse( pn.isPrimeNumber(9) );
		Assert.assertTrue( pn.isPrimeNumber(11) );
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIsPrimeNumberWithInvalidInput() {
		pn.isPrimeNumber(0);
	}

}
