package com.home.stream;

import java.util.Random;
import java.util.stream.Stream;

public class Generate {
	public static void main(String[] args) {
		Stream.generate(new Random()::nextDouble)
			.limit(10)
			.forEach(System.out::println);
	}
}
