package com.home.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JavaFileReader {

	public void readLines(String filepath) {
		try( Stream<String> lines = Files.lines(Paths.get(filepath), Charset.defaultCharset()) ) {
			lines.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		System.out.println(args[0]);
		JavaFileReader jfr = new JavaFileReader();
		jfr.readLines(args[0]);
	}
}
