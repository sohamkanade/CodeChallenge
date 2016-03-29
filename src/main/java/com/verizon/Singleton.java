package com.verizon;

public class Singleton {

	private Singleton() {}

	/** 
	 * Initializes singleton. 
	 * 
	 * {@link SingletonHolder} is loaded on the first execution of {@link Singleton#getInstance()} or the first access to 
	 * {@link SingletonHolder#INSTANCE}, not before. 
	 */ 
	private static class SingletonHolder { 
		private static final Singleton INSTANCE = new Singleton(); 
	}

	public static Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
