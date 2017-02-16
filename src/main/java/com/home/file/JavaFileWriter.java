package com.home.file;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

public class JavaFileWriter {

	public void write(String filepath, String data) {
		try( FileOutputStream output = new FileOutputStream(new File(filepath)) ) {
			output.write(data.getBytes(Charset.defaultCharset()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(args[0]);
		JavaFileWriter jfw = new JavaFileWriter();
		jfw.write(args[0], args[1]);
	}
}
