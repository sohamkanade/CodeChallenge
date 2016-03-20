package com.home.unicode;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class UnicodeDetection {

	public static void main(String[] args) {
		String data = "AÜXÜ�";
		System.out.println(Normalizer.normalize(data, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", ""));
		System.out.println( data.chars().anyMatch(i -> Character.UnicodeBlock.of((char) i)!=Character.UnicodeBlock.BASIC_LATIN ) );
//		Stream<Character> converted = data.chars().mapToObj(i -> {
//			if(Character.UnicodeBlock.of((char) i)==Character.UnicodeBlock.BASIC_LATIN) {
//				return (char)i;
//			} else {
//				return ' ';
//			}
//		});
		System.out.println(data.chars()
		                       .filter(i -> Character.UnicodeBlock.of((char) i)==Character.UnicodeBlock.BASIC_LATIN)
		                       .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		                       .toString());

		System.out.println( data.replaceAll("[^\\x00-\\x7F]", "") );
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String data2 = "Normal String !@#$%";
		System.out.println(Normalizer.normalize(data2, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", ""));
		System.out.println( data2.chars().anyMatch(i -> Character.UnicodeBlock.of((char) i)!=Character.UnicodeBlock.BASIC_LATIN ) );
		System.out.println( data2.replaceAll("[^\\x00-\\x7F]", "") );
	}
}
