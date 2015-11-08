package com.home.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.home.test.Solution;
import com.home.test.Solution2;

public class SolutionTests {

	private Solution solution;
	private Solution2 solution2;

	@Before
	public void setUp() throws Exception {
		solution = new Solution();
		solution2 = new Solution2();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCal() {
		char result = solution.cal('2', '*', '2');
		assertTrue( result == '4');
	}

	@Test
	public void testCalculate() {
		int result = solution.calculate("3+2*2");
		assertTrue (result == 7);
		result = solution.calculate(" 3/2 ");
		assertTrue (result == 1);
		result = solution.calculate(" 3+5 / 2 ");
		assertTrue (result == 5);
//		result = solution.calculate("42");
//		assertTrue (result == 5);
	}

	@Test
	public void testCalOnSolution2() {
		int result = solution2.calculate("3+2*2");
		assertTrue (result == 7);
		result = solution2.calculate(" 3/2 ");
		assertTrue (result == 1);
		result = solution2.calculate(" 3+5 / 2 ");
		assertTrue (result == 5);
		result = solution2.calculate("42");
		assertTrue (result == 42);
		result = solution2.calculate("2-1");
		assertTrue (result == 1);
		result = solution2.calculate("1-1+1");
		assertTrue (result == 1);
	}

}
