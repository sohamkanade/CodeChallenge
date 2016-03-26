package com.home.test;

public class Singleton {
	private static Singleton instance;

	private Singleton() {}

	public Singleton getInstance() {
		if(null == instance) {
			synchronized(Singleton.class) {
				instance = new Singleton();
			}
		}
		return instance;
	}
}
