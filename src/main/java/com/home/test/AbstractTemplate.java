package com.home.test;

public abstract class AbstractTemplate {
	abstract protected void read();
	abstract protected void write();

	public void run() {
		read();
		write();
	}
}
