package com.leetcode.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MovingAverage m = new MovingAverage(3);
	m.next(1) = 1
	m.next(10) = (1 + 10) / 2
	m.next(3) = (1 + 10 + 3) / 3
	m.next(5) = (10 + 3 + 5) / 3

 * @author spark
 *
 */
public class MovingAverage {
	private List<Integer> list;
	private int size;

	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		this.size = size;
		list = new LinkedList<Integer>();
	}

	public double next(int val) {
		if(list.size() >= size) {
			list.remove(0);
		}
		list.add(val);
		return list.stream().collect(Collectors.averagingDouble(Integer::intValue));
	}
}
