package com.verizon;

public class Singleton {

	private Singleton() {}

	/** 
	 * Initializes singleton. 
	 * 
	 * {@link LazySingletonHolder} is loaded on the first execution of {@link Singleton#getInstance()} or the first access to 
	 * {@link LazySingletonHolder#INSTANCE}, not before. 
	 */ 
	private static class LazySingletonHolder { 
		private static final Singleton INSTANCE = new Singleton(); 
	}

	public static Singleton getInstance() {
		return LazySingletonHolder.INSTANCE;
	}
}
