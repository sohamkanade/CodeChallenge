package com.home.count;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class UniqueWordCount {

	public long getUniqueWordCount(String filepath) {
		long count = 0;
		try( Stream<String> lines = Files.lines(Paths.get(filepath), Charset.defaultCharset()) ) {
			count = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return count;
	}

	public static void main(String[] args) {
		UniqueWordCount uwc = new UniqueWordCount();
		System.out.println( uwc.getUniqueWordCount("/Users/spark/visualvm/visualvm_138/LICENSE.txt") );
	}
}
