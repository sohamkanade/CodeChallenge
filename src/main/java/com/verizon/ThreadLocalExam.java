package com.verizon;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalExam {
	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
			System.out.println("create new simpleDateFormat");
			return new SimpleDateFormat("MM/dd/yy");
		}
	};

	public static String formatCurrentDate(Date date) {
		return df.get().format(date);
	}

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = () ->  System.out.println("["+ Thread.currentThread().getName() +"]: ".concat(ThreadLocalExam.formatCurrentDate(new Date())));
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
	}
}
