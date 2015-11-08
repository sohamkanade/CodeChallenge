package com.home.test;


public class CSVParser {

	public String[] getParsed(String line) {
//		line = line.replace('\'', '\'');
		return line.split(",");
	}
}
