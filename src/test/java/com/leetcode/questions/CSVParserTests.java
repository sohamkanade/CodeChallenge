package com.leetcode.questions;

import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.home.test.CSVParser;

public class CSVParserTests {

	private CSVParser parser;

	@Before
	public void setUp() throws Exception {
		parser = new CSVParser();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetParsed() {
		String sampleData = "data 1,column 2,' some my data',last one";
		String[] results = parser.getParsed(sampleData);
		Stream.of(results).forEach(System.out::println);
	}

}
