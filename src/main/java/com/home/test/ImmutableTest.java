package com.home.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class ImmutableTest {
	private final int value;
	private final Date date;
	private final List<String> list = new ArrayList<>();
	
	public ImmutableTest(Integer value, Date date, List<String> subList) {
		this.value = value;
		this.date = (Date)date.clone();
		this.list.addAll(subList);
	}
	
	public Integer getValue() {
		return value;
	}

	public Date getDate() {
		return (Date) date.clone();
	}

	public List<String> getList() {
//		return list;
		return Collections.unmodifiableList(list);
	}

	public static void main(String[] args) {
		ImmutableTest it = new ImmutableTest(6, new Date(), Arrays.asList("a1", "a2"));
		System.out.println( it.getValue() );
		System.out.println( it.getDate());
		it.getDate().setTime(78031427L);
		System.out.println( it.getDate());
		System.out.println(it.getList().stream().collect(Collectors.joining(";")));
		it.getList().add("a3");
		System.out.println(it.getList().stream().collect(Collectors.joining(";")));
	}
}
