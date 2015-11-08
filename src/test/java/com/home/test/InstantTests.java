package com.home.test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InstantTests {

	static Logger log = Logger.getLogger(InstantTests.class.getName());

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime now = LocalDateTime.now();
		Instant instant = now.atZone(ZoneId.systemDefault()).toInstant().truncatedTo(ChronoUnit.SECONDS);
		Date date = Date.from(instant);
		log.info("now : ".concat(sdf.format(date)));
		
		// this is for comparison
		Date d = new Date();
		log.info(sdf.format(d));
	}

	@Test
	public void test2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		Instant instant = now.toInstant().truncatedTo(ChronoUnit.SECONDS);
		Date date = Date.from(instant);
		log.info("now : ".concat(sdf.format(date)));
	}

}
