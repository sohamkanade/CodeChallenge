package com.verizon;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PerThreadFormatter {
	private static final ThreadLocal<SimpleDateFormat> dateFormatHolder = new ThreadLocal<SimpleDateFormat>() {

		/*
		 * initialValue() is called
		 */
		@Override
		protected SimpleDateFormat initialValue() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
			System.out.println("Creating SimpleDateFormat for Thread : " + Thread.currentThread().getName() + ", "+ sdf.toString());
			return sdf;
		}
	};

	/*
	 * Every time there is a call for DateFormat, ThreadLocal will return calling
	 * Thread's copy of SimpleDateFormat
	 */
	public static DateFormat getDateFormatter() {
		return dateFormatHolder.get();
	}

}
