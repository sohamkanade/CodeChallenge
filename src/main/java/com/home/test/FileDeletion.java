package com.home.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileDeletion {

	public static void main(String[] args) {
		File target = new File("/Users/spark/Desktop/test_delete.txt");
		try {
			Files.delete(target.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
