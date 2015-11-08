package com.home.test;

public class ConcreteTemplate extends AbstractTemplate {

	@Override
	protected void read() {
		System.out.println("read");

	}

	@Override
	protected void write() {
		// TODO Auto-generated method stub
		System.out.println("write");
	}

}
