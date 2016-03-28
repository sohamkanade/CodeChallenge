package com.expedia;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Can you sort
 * @author spark
 * 
 * 
 * 3 1 2 2 4 => 1 3 4 2 2
 *
 */
public class Solution1 {
	static void sort(int[] arr) {
		// build original value - frequency map
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++) {
			Integer value = freqMap.get(arr[i]);
			if(null == value) {
				value = 1;
			} else {
				value++;
			}
			freqMap.put(arr[i], value);
		}
		Map<Integer, Integer> sorted = sort(freqMap);
		for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
			for(int i = 1; i <= entry.getValue(); i++) {
				System.out.println(entry.getKey());
			}
		}
	}

	static Map<Integer, Integer> sort(Map<Integer, Integer> map) {
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
				if(e1.getValue().compareTo(e2.getValue()) == 0) {
					return e1.getKey().compareTo(e2.getKey());
				}
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
		for (Iterator<Map.Entry<Integer, Integer>> it = list.iterator(); it.hasNext();) {
			Map.Entry<Integer, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	public static void main(String[] args) {
		int[] arr= {3,1,2,2,4};
		sort(arr);
	}
}
