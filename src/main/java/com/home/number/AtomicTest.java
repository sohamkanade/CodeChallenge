package com.home.number;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest {

	private AtomicLong number = new AtomicLong(0);

	public AtomicLong getNumber() {
		return number;
	}

	public long getNumberLong() {
		return number.get();
	}

	public static void main(String[] args) {
		Long myLong = new Long(20);
		AtomicTest at = new AtomicTest();
		at.getNumber().getAndSet(myLong);
		System.out.println(at.getNumber().incrementAndGet());
		System.out.println(at.getNumber().incrementAndGet());
	}
}
