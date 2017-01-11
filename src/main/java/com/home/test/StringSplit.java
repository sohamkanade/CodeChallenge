package com.home.test;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringSplit {
	
	public static final String DELIMITER = "-";

	public static void main(String[] args) {
//		String data = "propertyId";
//		String data2 = "jobId-propertyId";
//		
//		String[] values = StringUtils.split(data, DELIMITER);
//		for(int i = 0; i < values.length; i++) {
//			System.out.println("" +i+": "+values[i]);
//		}
//		
//		values = StringUtils.split(data2, DELIMITER);
//		for(int i = 0; i < values.length; i++) {
//			System.out.println("" +i+": "+values[i]);
//		}

		String baseDN = "cn=users,dc=texturallc,dc=net";
		List<String> list = Arrays.asList(baseDN.split("dc="));
		list.forEach(System.out::println);
		
	}
}
