package com.home.test;

import java.util.ArrayList;
import java.util.List;

public class ObjectFinal {

	public final List<Integer> myList =new ArrayList<>();

	public static void main(String[] args) {
		ObjectFinal obj = new ObjectFinal();
		obj.myList.add(1);
		obj.myList.add(10);
		obj.myList.add(3);
		obj.myList.forEach(System.out::println);
	}
}
