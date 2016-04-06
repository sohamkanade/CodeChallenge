package com.verizon;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;


public class ThreadLocalTest {

	public static void main(String args[]) throws IOException {
		Runnable runnable = () -> {
			for(int i=0; i<2; i++){
				System.out.println("Thread: " + Thread.currentThread().getName() + " Formatted Date: " + ThreadLocalTest.threadSafeFormat(Thread.currentThread().getName(), new Date()) );
			}
		};
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);

		t1.start();
		t2.start();
	}

	/*
	 * Thread safe format method because every thread will use its own DateFormat
	 */
	public static String threadSafeFormat(String threadName, Date date){
		DateFormat formatter = PerThreadFormatter.getDateFormatter();
		System.out.println("threadName, formatter: ".concat(formatter.toString()));
		return formatter.format(date);
	}

}