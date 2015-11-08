package com.leetcode.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThreadSafeTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Wrapper implementations delegate all their real work to a specified collection 
	 * but add extra functionality on top of what this collection offers. 
	 * For design pattern fans, this is an example of the decorator pattern. 
	 * Although it may seem a bit exotic, it's really pretty straightforward.
	 * 
	 * The synchronization wrappers add automatic synchronization (thread-safety) to an arbitrary collection. 
	 * Each of the six core collection interfaces — Collection, Set, List, Map, SortedSet, and SortedMap — has one static factory method.
	 */
	@Test
	public void testSynchronizedCollection() {
		List<String> c = Collections.synchronizedList(new ArrayList<>());
		synchronized(c) {
			c.add("John");
			c.add("Mark");
			c.add("Matt");
			c.stream().forEach(System.out::println);
		}

		Map<String, Integer> m = Collections.synchronizedMap(new HashMap<>());
		Set<String> s = m.keySet();
		synchronized(m) {
			m.put("a", 1);
			m.put("b", 2);
			m.put("c", 8);
			s.stream().mapToInt(key -> m.get(key)).forEach(System.out::println);;
		}
	}
	

	/**
	 * Unmodifiable Wrappers
	 * 
	 * To make a collection immutable once it has been built. 
	 * In this case, it's good practice not to maintain a reference to the backing collection. 
	 * This absolutely guarantees immutability.
	 * 
	 * To allow certain clients read-only access to your data structures. 
	 * You keep a reference to the backing collection but hand out a reference to the wrapper. 
	 * In this way, clients can look but not modify, while you maintain full access.
	 */
	@Test
	public void testUnmodifiedCollection() {
		List<String> names = new ArrayList<>();
		names.add("Ryan");
		names.add("Mike");
		List<String> readOnlyNames = Collections.unmodifiableList(names);
//		readOnlyNames.add("John"); <- UnsupportedOperationException

		readOnlyNames.forEach(System.out::println);
	}

}
