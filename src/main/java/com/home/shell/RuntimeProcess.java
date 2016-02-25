package com.home.shell;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RuntimeProcess {
	private Process processWithTimeout;

	public String executeWithReader(Process process) {
		String line = null;
		try {
			try(InputStream is = process.getInputStream()) {
				try(InputStreamReader isr = new InputStreamReader(is)) {
					try(BufferedReader br = new BufferedReader(isr)) {
						while ((line = br.readLine()) != null) {
							System.out.println(line);
							break; // you can comment out break for simulating long lasting job without finish
						}
					}
				}
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		return line;
	}

	public String runAsyncWithTimeout(final String command) {
		ExecutorService executor = null;
		String response = null;
		processWithTimeout = null;
		try {
			Runtime runtime = Runtime.getRuntime();
			processWithTimeout = runtime.exec(command);
			Callable<String> c1 = () -> executeWithReader(processWithTimeout);

			executor = Executors.newFixedThreadPool(1);
			response = executor.invokeAny(Arrays.asList(c1), 10, TimeUnit.SECONDS);
			System.out.println("finished!");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(null != processWithTimeout) {
				processWithTimeout.destroy();
			}
			if(null != executor) {
				try{
					executor.awaitTermination(3, TimeUnit.SECONDS);
				} catch(Exception e2) {
					System.out.println(e2);
				}
				executor.shutdownNow();
			}
		}
		return response;
	}

	public void run(String command) {
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(command);
			process.waitFor(3, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			process.destroy();
		}
	}

	/*
		1) current_time.sh: print current time to console and date.txt file in every second
		2) current_time2.sh: print current time only to date.txt file in every second, 
							this is for simulating we fail to get output from console but the process keep running
	*/
	public static void main(String[] args) {
	
		RuntimeProcess rp = new RuntimeProcess();
//		rp.runAsyncWithTimeout("./current_time.sh");
//		rp.runAsyncWithTimeout("./current_time2.sh");
		rp.run("cmd /c start current_time.bat");
	}
}
