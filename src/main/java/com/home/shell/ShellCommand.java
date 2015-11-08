package com.home.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ShellCommand {

	public void ping() {
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec("ping google.com");
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("finished!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listFile(String pattern) {
		try {
			Process process = new ProcessBuilder("ls", pattern).start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			System.out.println("finished!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void openBrowser() {
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec("cmd /c start \"open browser\" /max iexplore.exe");
			System.out.println("finished!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		ShellCommand sc = new ShellCommand();
		sc.ping();
		//		sc.openBrowser();
//		sc.listFile("*.java");
	}
}
