package com.home.test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeZone {

	public static void main(String[] args) {
		String epochTime = "1436831775043";

		Instant utcInstant = new Date(Long.parseLong(epochTime)).toInstant();
		ZonedDateTime there = ZonedDateTime.ofInstant(utcInstant, ZoneId.of("UTC"));
		System.out.println(utcInstant.toString());
		ZonedDateTime there2 = ZonedDateTime.parse(utcInstant.toString(), DateTimeFormatter.ISO_DATE_TIME);

		LocalDateTime ldt = LocalDateTime.ofInstant(there2.toInstant(), ZoneId.systemDefault());
		Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(out.toString());

		//Date.from(ZonedDateTime.parse(errorMap.get(KEY_DATETIME), DateTimeFormatter.ISO_DATE_TIME).toInstant()),
	}
}
