package com.home.test;

public class StringManipulation {

	public static void main(String[] args) {
		System.out.println( StringManipulation.removeRevisionRetention("00007028OF-JUN2016-05R") );

		System.out.println( StringManipulation.removeRevisionRetention("00007028OF-JUN2016-05A") );

		System.out.println( StringManipulation.removeRevisionRetention("00007028OF-JUN2016-05RA") );

		System.out.println( StringManipulation.removeRevisionRetention("00007028OF") );
	}

	public static String removeRevisionRetention(String str) { 
		int endOfStr = str.lastIndexOf("OF"); 
		int lastChar = str.length() - 1; 
		if (endOfStr == lastChar-1){ 
			return str; 
		} 
		if (Character.isLetter(str.charAt(lastChar))) { 
			return removeRevisionRetention(str.substring(0,lastChar)); 
		} else { 
			return str; 
		} 
	} 
}
