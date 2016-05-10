package com.home.test;

public final class ImmutableTest {
	private final Integer value;
	
	public ImmutableTest(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}

}
