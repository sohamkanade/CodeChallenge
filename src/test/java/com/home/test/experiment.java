package com.home.test;

import org.apache.log4j.Logger;
import org.junit.Test;

import junit.framework.TestCase;

public class experiment extends TestCase {

	static Logger log = Logger.getLogger(experiment.class.getName());

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testSomething() {
		log.info("run test");
	}

}
