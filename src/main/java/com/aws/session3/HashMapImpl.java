package com.aws.session3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HashMapImpl {

	List<Set<Node>> array = new ArrayList<Set<Node>>(50);

	public void put(String key, String value) {
		array.get(key.hashCode() % array.size()).add(new Node(key,value));
	}

	public String get(String key) {
		return array.get(key.hashCode() % array.size())
					.stream()
					.filter(node -> node.getKey().equals(key))
					.map(Node::getValue)
					.findFirst()
					.get();
	}

	public class Node {
		private String key;
		private String value;

		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
}
